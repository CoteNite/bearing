package cn.cotenite.bearing.domain.vo.rsp;

import lombok.Builder;
import lombok.Data;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:22 PM
 */
@Data
@Builder
public class CaptchaVO {

    private String key;

    private String captcha;
}
