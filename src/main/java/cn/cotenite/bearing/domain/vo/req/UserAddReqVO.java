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
public class UserAddReqVO {

    private String id;

    @NotBlank
    private String userName;

    @NotBlank
    private String realName;

    @NotBlank
    private String password;

    private Integer scheduleId;

    @NotNull
    private Integer role;

}
