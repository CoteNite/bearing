package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 6:41 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingWrongFinishedVO {

    @NotNull
    private Long userId;

    @NotNull
    private Long bearingId;


}

