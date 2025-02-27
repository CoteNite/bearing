package cn.cotenite.bearing.common.expection;

import cn.cotenite.bearing.common.enums.ResponseErrorEnum;
import lombok.*;

import java.io.Serial;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 4:54 AM
 */
public class BizException extends RuntimeException{
    @Serial
    private static final long serialVersionUID = -7864604160297181941L;

    private final int code;

    private final String message;

    public  BizException(int code, String message) {
        this.code=code;
        this.message=message;
    }

    public BizException(ResponseErrorEnum errorEnum){
        this.code= Integer.parseInt(errorEnum.getErrorCode());
        this.message=errorEnum.getErrorMessage();
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return message;
    }


}
