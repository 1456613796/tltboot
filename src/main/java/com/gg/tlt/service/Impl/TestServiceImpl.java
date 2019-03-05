package com.gg.tlt.service.Impl;

import com.gg.tlt.mapper.TestMapper;
import com.gg.tlt.model.User;
import com.gg.tlt.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    TestMapper testMapper;


    @Override
    public List<User> queryAllUsers() {
        return testMapper.selectAllUsers();
    }

    @Override
    public Integer addUser(User user) {
        return testMapper.insertUser(user);
    }

    @Override
    public Integer removeById(String id) {
        return testMapper.deleteById(id);
    }


    @Override
    public Integer modifyUser(String username, Integer age, String id, Integer sex) {
        return testMapper.updateUserById(username, age, id, sex);
    }

    @Override
    public String selectUserNameById(String id) {
        return testMapper.selectUserNameById(id);
    }
}
