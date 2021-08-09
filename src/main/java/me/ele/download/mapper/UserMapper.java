package me.ele.download.mapper;

import me.ele.download.pojo.User;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

}
