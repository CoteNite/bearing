package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/25/2025 8:44 PM
 */
@Data
public class LoginReqVO {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String key;

    @NotEmpty
    @Length(min = 4,max = 4)
    private String code;

    private Boolean rememberMe;

}
