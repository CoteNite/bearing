package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/5/2025 7:10 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateReqVO {

    @NotBlank
    private String id;

    private String userName;

    private String realName;

    private String password;

    private Integer scheduleId;

    private Integer role;
}
