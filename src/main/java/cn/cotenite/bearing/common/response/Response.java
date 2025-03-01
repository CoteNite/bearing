package cn.cotenite.bearing.common.response;

import cn.cotenite.bearing.common.enums.ResponseErrorEnum;
import cn.cotenite.bearing.common.expection.BizException;
import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:12 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response<T> {
    
    Integer code;
    
    T data;
    
    String msg;

    public static <T> Response<T> success(T data) {
        return new Response<>(200, data,"success");
    }
    public static <T> Response<T> success() {
        return new Response<>(200, null,"success");
    }

    public static <T> Response<T> failure(int code, String message) {
        return new Response<>(code, null,message);
    }

    public static <T> Response<T> failure(Exception e) {
        return new Response<>(200,null,e.getMessage());
    }

    public static <T> Response<T> failure(BizException e) {
        return new Response<>(200,null,e.getMessage());
    }

    public static <T> Response<T> failure(ResponseErrorEnum error) {
        return new Response<>(Integer.valueOf(error.getErrorCode()),null,error.getErrorMessage());
    }

    public static <T> Response<T> unauthorized(String message){
        return failure(401,message);
    }
    public static <T> Response<T> forBidden(String message){
        return failure(403,message);
    }

    public String asJsonString(){
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }

    public static <T> Response<T> forbidden(String message){
        return failure(403, message);
    }

    public static <T> Response<T> noPermission(){
        return new Response<>(401,null,"权限不足，禁止访问!");
    }
    
}
