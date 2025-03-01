package cn.cotenite.bearing.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:16 PM
 */
@Getter
@AllArgsConstructor
public enum StatusEnum {

    WAITING(0,"尚未分配工人"),
    PARING(1,"工人正在去维修"),
    FINISHED(2,"维修已完成")
    ;


    private Integer code;

    private String docs;

    public static String getStatus(int code){
        StatusEnum[] values = StatusEnum.values();
        for (StatusEnum item:values){
            if (item.getCode()==code){
                return item.getDocs();
            }
        }
        return null;
    }
}
