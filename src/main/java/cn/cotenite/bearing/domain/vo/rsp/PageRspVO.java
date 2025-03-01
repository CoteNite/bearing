package cn.cotenite.bearing.domain.vo.rsp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:33 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRspVO<T> {

    private Long pageNo;

    private Long pageSize;

    private List<T> dataList;
}
