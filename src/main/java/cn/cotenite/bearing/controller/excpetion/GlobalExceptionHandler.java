package cn.cotenite.bearing.controller.excpetion;

import cn.cotenite.bearing.common.enums.ResponseErrorEnum;
import cn.cotenite.bearing.common.expection.BizException;
import cn.cotenite.bearing.common.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 4:59 AM
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({BizException.class})
    @ResponseBody
    public Response<Void> handleException(HttpServletRequest request, BizException e) {
        log.error("{} 请求发生业务错误，错误原因：{}",request.getRequestURI(),e.getMsg());
        return Response.failure(e.getCode(),e.getMsg());
    }

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request,Exception e){
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.failure(ResponseErrorEnum.SYSTEM_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Response<Object> handleOtherException(HttpServletRequest request,MethodArgumentNotValidException e){
        log.error("{} request error, ", request.getRequestURI(), e);
        return Response.failure(ResponseErrorEnum.PARAM_NOT_VALID);
    }
}
