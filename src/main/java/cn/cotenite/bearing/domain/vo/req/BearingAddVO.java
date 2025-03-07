package cn.cotenite.bearing.domain.vo.req;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/7/2025 7:21 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingAddVO {

    /**
     * 0 正常 ，1出错
     */
    @NotNull
    private Integer status;

    /**
     *
     */
    @NotNull
    private String name;

    /**
     *
     */
    @NotNull
    private Long createUser;


}
