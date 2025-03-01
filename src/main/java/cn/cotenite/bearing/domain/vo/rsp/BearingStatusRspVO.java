package cn.cotenite.bearing.domain.vo.rsp;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/1/2025 9:40 PM
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BearingStatusRspVO {

    private Long id;

    private Long bearingId;

    private String status;

    private String wrong;

    private String nickname;

    private Date createTime;


}
