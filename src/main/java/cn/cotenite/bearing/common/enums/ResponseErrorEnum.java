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
    SYSTEM_ERROR("400", "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID("400", "您传入的参数存在错误，请检查后重试"),
    USER_NOT_FOUND("400","用户未找到"),
    CAPTCHA_ERROR("400","验证码错误"),
    AUTH_ERROR("401","登陆错误"),
    PASSWORD_OR_USERNAME_FAILURE("400","用户名或密码错误"),
    ROLE_ERROR("400","您当前的角色无权限进行该操作")
    ;

    // 异常码
    private final String errorCode;
    // 错误信息
    private final String errorMessage;
}
