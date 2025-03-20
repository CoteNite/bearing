package cn.cotenite.bearing.domain.vo.rsp;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:27 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingDetailVO {

    private Long id;

    private Integer status;

    private String name;

    private String realname;

    private LocalTime createTime;

}
