package com.gg.tlt.mapper;

import com.gg.tlt.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TestMapper {
    public List<User> selectAllUsers();

    public Integer insertUser(User user);

    public Integer deleteById(String id);

    public Integer updateUserById(@Param("username") String username,
                                  @Param("age") Integer age,
                                  @Param("id") String id,
                                  @Param("sex") Integer sex);

    public String selectUserNameById(@Param("id") String id);

}
