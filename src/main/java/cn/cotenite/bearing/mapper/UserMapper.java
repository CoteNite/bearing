package cn.cotenite.bearing.mapper;


import cn.cotenite.bearing.domain.po.User;
import cn.cotenite.bearing.domain.vo.rsp.UserDetailVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 29543
* @description 针对表【user】的数据库操作Mapper
* @createDate 2025-02-26 05:19:08
* @Entity cn.cotenite.bearing.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUserByUsername(@Param("username") String username);

    List<User> selectAllUser4Redis();

    UserDetailVO selectDetailById(Long id);

    List<UserDetailVO> selectDetailList(Page<User> userPage, @Param("realName") String realName,@Param("role") Integer role);
}




