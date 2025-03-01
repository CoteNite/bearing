package cn.cotenite.bearing.domain.vo.req;

import com.baomidou.mybatisplus.annotation.TableId;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:09 PM
 */
@Data
public class BearingStatusReqVO {

    @NotNull
    private Long bearingId;

    @NotNull
    private Integer wrong;

}
