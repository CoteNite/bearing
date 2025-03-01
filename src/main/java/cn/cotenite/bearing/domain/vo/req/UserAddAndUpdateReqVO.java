package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:20 PM
 */
@Data
public class UserAddAndUpdateReqVO {

    @NotBlank
    private String username;
    @NotBlank
    private String realName;
    @NotBlank
    private String password;
    @NotBlank
    private String startWorkTime;
    @NotBlank
    private String getOffWorkTime;
    @NotNull
    private Integer role;

}
