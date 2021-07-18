package com.course.testng.suite;


import org.testng.annotations.*;

public class loginTest {


    @Test
    public void  login(){

        System.out.println("登录成功");

    }


    @BeforeClass

    public void  BeforeClass(){

        System.out.println("打开浏览器");

    }


    @AfterClass

    public void  AfterClass(){

        System.out.println("关闭浏览器");

    }


    @BeforeMethod

    public void  login1(){

        System.out.println("浏览器页签输入登录网址，输入用户名密码");

    }


    @AfterMethod

    public void  login2(){

        System.out.println("退出登录");

    }

}
