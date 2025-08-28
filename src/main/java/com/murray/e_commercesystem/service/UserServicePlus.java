package com.murray.e_commercesystem.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.murray.e_commercesystem.entities.User;
import com.murray.e_commercesystem.mapper.UserMapperPlus;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@Service
public class UserServicePlus {
    @Autowired
    UserMapperPlus userMapperPlus;

    public List<User> findById(Wrapper<User> userWrapper) {
        return userMapperPlus.selectList(userWrapper);
    }

}
