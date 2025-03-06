package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/6/2025 9:14 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleUpdateVO {

    @NotNull
    private Long id;

    private LocalTime startTime;

    private LocalTime getOffTime;
}
