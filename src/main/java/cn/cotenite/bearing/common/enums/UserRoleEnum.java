package cn.cotenite.bearing.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 6:01 AM
 */
@Getter
@AllArgsConstructor
public enum UserRoleEnum {

    SUPER_ADMIN(0,"superAdmin"),
    ADMIN(1,"admin"),
    USER(2,"user")
    ;

    private int code;
    private String role;

    public static String getUserRole(int code){
        UserRoleEnum[] values = UserRoleEnum.values();
        for (UserRoleEnum item:values){
            if (item.getCode()==code){
                return item.getRole();
            }
        }
        return null;
    }

    public static Boolean checkCurrentRoleIsSuperAdmin(int code){
        return code==SUPER_ADMIN.getCode();
    }
}
