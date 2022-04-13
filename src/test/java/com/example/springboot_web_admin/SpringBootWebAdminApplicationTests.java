package com.example.springboot_web_admin;

import com.example.bean.User;
import com.example.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@Slf4j
@SpringBootTest     //springboot的测试类
class SpringBootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        Integer integer = jdbcTemplate.queryForObject("select count(*) from cate", int.class);
        System.out.println("查询总数:"+integer.toString());
    }

    @Test
    void userTest(){
        User user = userMapper.selectById(1L);
        log.info("用户{}",user);
    }

}
