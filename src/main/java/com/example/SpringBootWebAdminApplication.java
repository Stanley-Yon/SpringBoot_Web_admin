package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@MapperScan("com.example.mapper")
@ServletComponentScan("com.example")
@SpringBootApplication
public class SpringBootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebAdminApplication.class, args);
    }

}
