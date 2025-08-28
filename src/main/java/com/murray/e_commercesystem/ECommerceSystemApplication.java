package com.murray.e_commercesystem;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.murray.e_commercesystem.mapper")
public class ECommerceSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceSystemApplication.class, args);
    }

}
