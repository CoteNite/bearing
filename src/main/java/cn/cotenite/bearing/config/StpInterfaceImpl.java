package cn.cotenite.bearing.config;

import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.mapper.UserMapper;
import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.core.util.StrUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 6:06 AM
 */
@Component
public class StpInterfaceImpl implements StpInterface {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<String> getPermissionList(Object o, String s) {
        return null;
    }

    @Override
    public List<String> getRoleList(Object loginId, String s) {
        User user = userMapper.selectById((String) loginId);
        List<String> list=new ArrayList<>();
        String role=UserRoleEnum.getUserRole(user.getRole());
        if(StrUtil.isBlank(role)){
            throw new BizException("身份错误");
        }
        list.add(role);
        return list;
    }
}
