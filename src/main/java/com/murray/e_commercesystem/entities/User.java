package com.murray.e_commercesystem.entities;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author Murray
 * @email Murray50325487@gmail.com
 */
@Component
@Data
@ToString
@TableName(value = "test",keepGlobalPrefix = true)
public class User implements Serializable {
    @TableId(type=IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    @TableLogic(delval = "1",value = "0")
    private Boolean deleted;

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
