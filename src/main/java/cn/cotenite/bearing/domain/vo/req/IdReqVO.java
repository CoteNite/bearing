package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2025/3/11 22:03
 */
@Data
public class IdReqVO {
    @NotNull
    private Long id;
}
