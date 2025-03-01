package cn.cotenite.bearing.service.impl;

import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.common.utils.UserRoleHolder;
import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.UserAddAndUpdateReqVO;
import cn.cotenite.bearing.mapper.UserMapper;
import cn.cotenite.bearing.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:17 PM
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService  {

    @Resource
    private UserMapper userMapper;

    @Override
    public void addUser(UserAddAndUpdateReqVO reqVO) {
        User user=new User();
        String currentRole = UserRoleHolder.getCurrentUserRole();
        if(UserRoleEnum.checkCurrentRoleIsSuperAdmin(reqVO.getRole())&&!currentRole.equals(UserRoleEnum.SUPER_ADMIN.getRole())){
            throw new BizException("仅超管可以设置用户为超管权限");
        }
        BeanUtils.copyProperties(reqVO,user);
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        userMapper.insert(user);
    }

    @Override
    public void updateUser(UserAddAndUpdateReqVO reqVO) {

    }
}
