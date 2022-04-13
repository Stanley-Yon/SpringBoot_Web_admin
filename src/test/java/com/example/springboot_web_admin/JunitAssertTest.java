package com.example.springboot_web_admin;

import org.junit.jupiter.api.*;

import java.time.Duration;

/**
 * 断言机制
 */
public class JunitAssertTest {

    //断言出错，后面代码直接不执行
    @Test
    void TestAssertEquals(){
        Assertions.assertEquals(3,3,"是否相等");
        Assertions.assertNotEquals(2,3);
    }

    @Test
    void testAssertSame(){
        Object obj1=new Object();
        Object obj2 = new Object();
//        Assertions.assertSame(obj1,obj2,"对象不一样！！");
        Assertions.assertNotSame(obj1,obj2);
    }

    @Test
    void testAssertion(){
      //  Assertions.assertTrue(1>2?true:false);
        Assertions.assertFalse(1>2?true:false,"结果不为false");

        Assertions.assertNull(null);
        Assertions.assertNotNull(null);

    }

    /**
     * 数组断言
     */
    @Test
    void TestArrayAssertion(){
        int[] arr1 = {1, 2, 3};
        int[] arr2={2,3,4};
        int[] arr3={1,2,3};
        Assertions.assertArrayEquals(arr1,arr3,"arrays is not eauql");
      //  Assertions.assertArrayEquals(arr1,arr2,"arrays is not eauql");
    }

    /**
     * 组合断言
     */
    @Test
    void testAssertionAll(){
        Assertions.assertAll(()-> Assertions.assertEquals(1,1),
                ()-> Assertions.assertTrue(false));
    }

    @Test
    @DisplayName("异常断言")
    void testException(){
        //注意：测试的方法期望是抛出异常
        Assertions.assertThrows(Exception.class,()->{int i=1/0;} );
    }

    /**
     * 超时断言
     */
    @Test
    @DisplayName("超时测试")
    void testAssertionTimeout() {
        //超时就会报错
        Assertions.assertTimeout(Duration.ofMillis(500),()->Thread.sleep(500),
                                    "超时");
    }

    @Test
    @DisplayName("快速失败")
    void testFail(){
        System.out.println(1);
        if (1==1){
            Assertions.fail("直接失败");   // 执行这个语句整个test方法选择失败
        }
        System.out.println(2);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试start");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试over");
    }

}
