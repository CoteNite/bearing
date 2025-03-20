package cn.cotenite.bearing.domain.vo.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2025/3/20 22:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkOrderReqVO {

    private Long id;

    private String orderNumber;

    private String bearingId;

    private Integer wrong;

    private Integer status;

    private LocalTime createTime;

    private LocalTime updateTime;
}
