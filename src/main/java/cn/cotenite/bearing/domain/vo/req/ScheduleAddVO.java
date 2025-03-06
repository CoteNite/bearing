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
 * @Date 3/6/2025 8:58 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleAddVO {

    @NotNull
    private LocalTime startTime;

    @NotNull
    private LocalTime getOffTime;
}
