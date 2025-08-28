package com.murray.e_commercesystem.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.murray.e_commercesystem.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@Mapper
public interface UserMapper{
    public List<User> selectAllUsers();

    public IPage<User> paging(IPage<?> page, @Param("name") String username);
}
