package com.example.springboot_web_admin;


import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

/**
 * 常用注解的使用
 */
public class Junit5Test {

    @Disabled       //将测试方法弃用
    @Test
    @RepeatedTest(value = 5)
    @DisplayName(value = "测试RepeatedTest")
    void testRepestTest(){
        System.out.println(5);
    }

    @Test
    @DisplayName(value = "测试DisplayName")
    void testDisplayName(){
        System.out.println("hello");
    }

    @Test
    void testJunit(){
        System.out.println("test method -2");
    }

    @Timeout(value = 500,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(500);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试将要开始了");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试over");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有的测试方法将要start！！");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有的测试已经over！！");
    }

}
