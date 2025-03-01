package cn.cotenite.bearing.domain.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author RichardYoung
 * @Description
 * @Date 3/2/2025 3:14 AM
 */
@Data
public class UserRedisDTO {

    private String username;

    private String realName;

    private Integer role;
}
