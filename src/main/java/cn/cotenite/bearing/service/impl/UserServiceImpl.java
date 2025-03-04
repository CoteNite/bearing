package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.common.enums.ResponseErrorEnum;
import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.domain.dto.UserRedisDTO;
import cn.cotenite.bearing.domain.po.WorkerSchedule;
import cn.cotenite.bearing.domain.vo.req.UserUpdateReqVO;
import cn.cotenite.bearing.holder.UserRoleHolder;
import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.UserAddReqVO;
import cn.cotenite.bearing.mapper.UserMapper;
import cn.cotenite.bearing.mapper.WorkerScheduleMapper;
import cn.cotenite.bearing.service.UserService;
import cn.cotenite.bearing.utils.RedisKeyUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:17 PM
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService  {

    @Resource
    private UserMapper userMapper;

    @Resource
    private WorkerScheduleMapper workerScheduleMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void addUser(UserAddReqVO reqVO) {
        User user=new User();
        UserRoleEnum userRole = UserRoleHolder.getCurrentUserRole();
        if(UserRoleEnum.checkCurrentRoleIsSuperAdmin(reqVO.getRole())&&!userRole.equals(UserRoleEnum.SUPER_ADMIN)){
            throw new BizException("仅超管可以设置用户为超管权限");
        }
        BeanUtils.copyProperties(reqVO,user);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));

        userMapper.insert(user);

        updateWorkerSchedule(UserRoleEnum.getUserRoleByCode(user.getRole()),user.getId(),reqVO.getScheduleId());

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(UserUpdateReqVO reqVO) {

        User user=userMapper.selectById(reqVO.getId());

        if(user==null){
            throw new BizException(ResponseErrorEnum.PARAM_NOT_VALID);
        }

        BeanUtils.copyProperties(reqVO,user);

        UserRoleEnum userRole = UserRoleHolder.getCurrentUserRole();

        if(reqVO.getRole()!=null&&UserRoleHolder.getCurrentUserRole().equals(UserRoleEnum.SUPER_ADMIN)&&!userRole.equals(UserRoleEnum.SUPER_ADMIN)){
            throw new BizException("仅超管可以设置用户为超管权限");
        }


        if (StrUtil.isNotBlank(reqVO.getPassword())){
            user.setPassword(BCrypt.hashpw(reqVO.getPassword(),BCrypt.gensalt()));
        }

        userMapper.updateById(user);

        if(reqVO.getRole()!=null&&reqVO.getScheduleId()!=null){
            this.updateWorkerSchedule(UserRoleEnum.getUserRoleByCode(reqVO.getRole()),
                    user.getId(),reqVO.getScheduleId());
        }
    }

    @Override
    public void getAllUser4Redis() {
        List<User> users = userMapper.selectAllUser4Redis();
        Map<String,UserRedisDTO> userRedisDTOMap=new HashMap<>();
        for (User item:users){
            UserRedisDTO dto=new UserRedisDTO();
            BeanUtils.copyProperties(item,dto);
            userRedisDTOMap.put(item.getId().toString(),dto);
        }
        redisTemplate.opsForHash().putAll(RedisKeyUtil.buildUserHashKey(),userRedisDTOMap);
    }

    private void updateWorkerSchedule(UserRoleEnum userRoleEnum, Long workId,Integer scheduleId) {
        if (!UserRoleEnum.WORKER.equals(userRoleEnum)) {
            return;
        }

        WorkerSchedule schedule = WorkerSchedule
                .builder()
                .scheduleId(scheduleId)
                .workerId(workId)
                .build();
        workerScheduleMapper.insert(schedule);
    }
}
