package cn.cotenite.bearing.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 5:07 AM
 */
@AllArgsConstructor
@Getter
public enum ResponseErrorEnum {
    SYSTEM_ERROR("200", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("200", "您传入的参数存在错误，请检查后重试"),
    USER_NOT_FOUND("200","用户未找到"),
    CAPTCHA_ERROR("200","验证码错误"),
    PASSWORD_OR_USERNAME_FAILURE("200","用户名或密码错误")
    ;

    // 异常码
    private final String errorCode;
    // 错误信息
    private final String errorMessage;
}
