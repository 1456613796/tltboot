package com.gg.tlt.mapper;

import com.gg.tlt.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TestMapper {

    @Select("select * from user")
    public List<User> selectAllUsers();


    @Select("select * from user where ID = #{id}")
    public User selectUserById(@Param("id") String id);

    @Insert("INSERT INTO user(USERNAME,SEX,AGE,ID) VALUES(#{username},#{sex},#{age},#{id})")
    public Integer insertUser(User user);

    @Delete("DELETE FROM `user` WHERE ID = #{id}")
    public Integer deleteById(@Param("id") String id);

    @Update("UPDATE user SET USERNAME = #{username},AGE = #{age},SEX = #{sex} WHERE ID = #{id}")
    public Integer updateUserById(@Param("username") String username,
                                  @Param("age") Integer age,
                                  @Param("id") String id,
                                  @Param("sex") Integer sex);

    @Select("select `user`.USERNAME from `user` WHERE ID=#{id}")
    public String selectUserNameById(@Param("id") String id);

}
