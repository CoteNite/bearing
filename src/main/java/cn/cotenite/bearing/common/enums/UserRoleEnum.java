package cn.cotenite.bearing.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    WORKER(2,"user")
    ;

    private int code;
    private String docs;


    public static UserRoleEnum getUserRoleByCode(int code){
        UserRoleEnum[] values = UserRoleEnum.values();
        for (UserRoleEnum item:values){
            if (item.getCode()==code){
                return item;
            }
        }
        return null;
    }

    public static UserRoleEnum getUserRoleByDocs(String docs){
        UserRoleEnum[] values = UserRoleEnum.values();
        for (UserRoleEnum item:values){
            if (item.getDocs().equals(docs)){
                return item;
            }
        }
        return null;
    }


    public static Boolean checkCurrentRoleIsSuperAdmin(int code){
        return code==SUPER_ADMIN.getCode();
    }
}
