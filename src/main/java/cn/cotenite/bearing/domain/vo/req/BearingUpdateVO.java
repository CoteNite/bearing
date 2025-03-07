package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:23 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingUpdateVO {

    @NotNull
    private Long id;

    private Integer status;

    private String name;

    private Long createUser;

}
