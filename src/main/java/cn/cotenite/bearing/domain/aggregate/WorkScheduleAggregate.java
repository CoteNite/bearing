package cn.cotenite.bearing.domain.aggregate;

import lombok.Data;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 4:28 AM
 */
@Data
public class WorkScheduleAggregate {

    private Long workerId;

    private Integer scheduleId;

    private String startTime;

    private String getOffTime;

}
