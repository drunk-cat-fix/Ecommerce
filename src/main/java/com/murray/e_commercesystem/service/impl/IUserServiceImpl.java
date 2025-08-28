package com.murray.e_commercesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.murray.e_commercesystem.entities.User;
import com.murray.e_commercesystem.mapper.UserMapper;
import com.murray.e_commercesystem.mapper.UserMapperPlus;
import com.murray.e_commercesystem.service.IUserService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapperPlus,User> implements IUserService {

}
