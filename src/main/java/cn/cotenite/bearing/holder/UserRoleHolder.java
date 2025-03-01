package cn.cotenite.bearing.holder;

import cn.cotenite.bearing.common.enums.UserRoleEnum;
import cn.dev33.satoken.stp.StpUtil;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 8:39 PM
 */
public class UserRoleHolder {

    public static UserRoleEnum getCurrentUserRole(){
        return UserRoleEnum.getUserRoleByDocs(StpUtil.getRoleList().get(0));
    }

}
