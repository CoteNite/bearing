package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:19 PM
 */
@Data
public class PageReqVO {

    @NotNull
    private Integer pageCurrent;

    @NotNull
    @Max(30)
    private Integer pageSize;
}
