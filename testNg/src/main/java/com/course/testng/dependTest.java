package com.course.testng;


import org.testng.annotations.Test;

//依赖测试
public class dependTest {

    @Test
    public void test1 (){
        System.out.println("test1运行了");
        //抛出一个异常
        throw  new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2 (){
        System.out.println("test1成功运行了我再运行！！，不成功我就ignore不执行");

    }

}
