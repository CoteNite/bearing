package cn.cotenite.bearing.domain.vo.req;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime startTime;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime getOffTime;
}
