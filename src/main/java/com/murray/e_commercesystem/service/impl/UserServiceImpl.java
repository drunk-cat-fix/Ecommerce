package com.murray.e_commercesystem.service.impl;

import com.murray.e_commercesystem.entities.User;
import com.murray.e_commercesystem.mapper.UserMapper;
import com.murray.e_commercesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@Service
@Transactional(propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> findAllUsers() {
        return userMapper.selectAllUsers();
    }

}
