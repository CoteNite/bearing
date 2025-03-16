package cn.cotenite.bearing.domain.vo.rsp;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/26/2025 5:57 AM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRspVO {

    private Long userId;
    private String nickname;
    private String role;
    private String token;

}
