package cn.cotenite.bearing.common.utils;

import cn.dev33.satoken.stp.StpUtil;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 8:39 PM
 */
public class UserRoleHolder {

    public static String getCurrentUserRole(){
        return StpUtil.getRoleList().get(0);
    }

}
