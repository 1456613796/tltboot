package com.gg.tlt.service;

import com.gg.tlt.model.User;

import java.util.List;


public interface TestService {

    public List<User> queryAllUsers();

    public Integer addUser(User user);

    public Integer removeById(String id);

    public Integer modifyUser(String username, Integer age, String id, Integer sex);

    public String selectUserNameById(String id);

}
