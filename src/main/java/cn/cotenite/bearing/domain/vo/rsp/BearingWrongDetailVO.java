package cn.cotenite.bearing.domain.vo.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:31 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingWrongDetailVO {

    private Long id;

    private String bearingName;

    private Long bearingId;

    private Integer wrong;

    private Integer status;

    private LocalTime createTime;


}
