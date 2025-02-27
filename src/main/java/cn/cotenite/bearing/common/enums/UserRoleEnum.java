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

    ADMIN(0,"admin"),
    USER(1,"user")
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

    public static List<String> getAllRole(){
        List<String> list=new ArrayList<>();
        UserRoleEnum[] values = UserRoleEnum.values();
        for (UserRoleEnum item:values){
            list.add(item.getRole());
        }
        return list;
    }
}
