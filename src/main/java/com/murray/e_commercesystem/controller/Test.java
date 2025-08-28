package com.murray.e_commercesystem.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.support.SFunction;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.murray.e_commercesystem.entities.User;
import com.murray.e_commercesystem.mapper.UserMapper;
import com.murray.e_commercesystem.service.IUserService;
import com.murray.e_commercesystem.service.UserService;
import com.murray.e_commercesystem.service.UserServicePlus;
import com.murray.e_commercesystem.service.impl.IUserServiceImpl;
import com.murray.e_commercesystem.service.impl.UserServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@RestController
public class Test {

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserServicePlus userServicePlus;

    @Autowired
    UserMapper userMapper;

    @Autowired
    IUserServiceImpl iUserService;
    @RequestMapping("/test")
    public String test() {
        return "This test controller";
    }

    @RequestMapping("/selectAllUsers")
    public List<User> queryAllUsers() {
        System.out.println(userService.findAllUsers());
        System.out.println(userService.findAllUsers().size());
        return userService.findAllUsers();
    }


//    @RequestMapping("/selectAllUsersByPlus")
//    public User queryAllUsersByPlus(){
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",10000);
//        System.out.println(userServicePlus.findById(wrapper));
//        return userServicePlus.findById(10000);
//    }

    @RequestMapping("/lambda")
    public List<User> lambda() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("id", 10000);
        LambdaQueryWrapper<User> eq = lambdaQueryWrapper.eq(User::getId, 10000);
        List<User> users = userServicePlus.findById(lambdaQueryWrapper);
        users.forEach(System.out::println);
        return userServicePlus.findById(lambdaQueryWrapper);
    }


    @RequestMapping("/getById")
    public List<User> test1(){
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getId,10000);

        System.out.println("IUserService : "+iUserService.count());
        return userServicePlus.findById(wrapper);
    }


    @GetMapping("/addUser/{username}/{password}")
    public boolean addUser(@PathVariable String  username,@PathVariable String password){
        User user = new User();
        user.setId(10002);
        user.setUsername(username);
        user.setPassword(password);

        return iUserService.save(user);
    }

    @GetMapping("/getPage/{current}/{size}")
    public IPage<User> testPage(
            @PathVariable Integer current,
            @PathVariable Integer size
    ){
        Page<User> userPage = new Page<>(current, size);

        return userMapper.paging(userPage,"test");
    }

    @GetMapping("/removeById/{id}")
    public boolean removeById(@PathVariable Integer id){
       return iUserService.removeById(id);
    }

    @GetMapping("/queryById/{id}")
    public User queryById(@PathVariable Integer id){
        return iUserService.getById(id);
    }

}
