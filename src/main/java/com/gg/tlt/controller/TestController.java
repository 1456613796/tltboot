package com.gg.tlt.controller;

import com.gg.tlt.mapper.TestMapper;
import com.gg.tlt.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
//@RestController("/")//等价于@responseBody
public class TestController {

    @Resource
    TestMapper testMapper;

    @RequestMapping("/index")
    public String index(Model model) {
        List<User> users = testMapper.selectAllUsers();
        model.addAttribute("user_list", users);
        return "index";
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public Integer addUser(@RequestParam("username") String username,
                           @RequestParam("id") String id,
                           @RequestParam("sex") String sex,
                           @RequestParam("age") String age) {
        User user = new User(username, Integer.parseInt(sex), Integer.parseInt(age), id);
        try {
            int result = testMapper.insertUser(user);
            if (result == 0)
                return 0;
            else if (result > 0)
                return result;
            else
                return -1;
        } catch (Exception e) {
            return -1;
        }

    }

    @RequestMapping("/deleteUserById")
    @ResponseBody
    public Integer deleteUserById(@RequestParam("id") String id) {
        System.out.println("删除用户:"+id);
        try {
            int result = testMapper.deleteById(id);
            if (result >= 0)
                return result;
            else
                return -2;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @RequestMapping("/updateUserMsg")
    @ResponseBody
    public Integer updateUserMsg(@RequestParam("username") String username,
                                 @RequestParam("sex") String sex,
                                 @RequestParam("age") String age,
                                 @RequestParam("id") String id) {

        System.out.println("编号为"+id+"请求用户信息变更");

        try{
            int result = testMapper.updateUserById(username,Integer.parseInt(age),id,Integer.parseInt(sex));
            if(result>=0) {
                System.out.println("变更成功");
                return result;
            }
            else
                return -2;
        }catch (Exception e){
            e.printStackTrace();
            return -2;
        }
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public String selectUserNameById(@PathVariable(value = "id") String id) {

        return testMapper.selectUserNameById(id);
    }
}
