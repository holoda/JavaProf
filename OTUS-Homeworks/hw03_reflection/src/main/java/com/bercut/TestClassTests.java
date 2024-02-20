package com.bercut;

import com.bercut.annotations.After;
import com.bercut.annotations.Before;
import com.bercut.annotations.Test;

public class TestClassTests {

    TestClass tc;

    @Before
    public void beforeTest(){
        System.out.println("beforeTest start");
        tc = new TestClass();
    }

    @After
    public void afterTest(){
        System.out.println("afterTest start");
        tc = null;
    }

    @Test
    public void test1(){
        System.out.println("test1 start");
        tc.setA(1);
        tc.setB(2);
        int result = tc.testMethod();
        System.out.println("Result = "+result);
    }

    @Test
    public void test2(){
        System.out.println("test2 start");
        tc.setA(10);
        tc.setB(20);
        int result = tc.testMethod();
        System.out.println("Result = "+result);
    }
}
