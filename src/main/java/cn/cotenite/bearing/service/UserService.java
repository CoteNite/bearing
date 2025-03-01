package cn.cotenite.bearing.service;

import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.req.UserAddAndUpdateReqVO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Author RichardYoung
 * @Description
 * @Date 2/28/2025 9:17 PM
 */
public interface UserService extends IService<User> {

    void addUser(UserAddAndUpdateReqVO reqVO);

    void updateUser(UserAddAndUpdateReqVO reqVO);
}
