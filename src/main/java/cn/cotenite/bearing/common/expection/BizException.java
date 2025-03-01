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


    private final String message;

    public  BizException( String message) {
        this.message=message;
    }

    public BizException(ResponseErrorEnum errorEnum){
        this.message=errorEnum.getErrorMessage();
    }

    public String getMsg() {
        return message;
    }


}
