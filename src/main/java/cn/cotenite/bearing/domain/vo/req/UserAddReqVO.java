package cn.cotenite.bearing.domain.vo.req;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:20 PM
 */
@Data
public class UserAddReqVO {


    private Long id;

    private String username;

    private String nickname;

    private String password;

    private Integer role;

}
