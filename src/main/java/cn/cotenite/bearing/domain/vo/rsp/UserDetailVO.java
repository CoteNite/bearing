package cn.cotenite.bearing.domain.vo.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/6/2025 10:02 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailVO {

    private Long id;

    private String username;

    private String realName;

    private LocalTime startTime;

    private LocalTime getOffTime;

    private Integer role;
}
