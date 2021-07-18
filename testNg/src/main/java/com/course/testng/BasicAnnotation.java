package com.course.testng;

//异常测试
import org.testng.annotations.*;

public class BasicAnnotation {


    //一个测试方法，方法标记为测试的一部分
    //主要是掌握各个注解的执行顺序
    @Test
    public void testCase1(){

        System.out.println("test1");

    }


    @Test
    public void testCase2(){

        System.out.println("test2");

    }

    @BeforeMethod
    public  void BeforeMethod  (){

        System.out.println("BeforeMethod：在各个@test方法运行之前执行");

    }

    @AfterMethod
    public  void AfterMethod  (){

        System.out.println("AfterMethod：在各个@test方法运行之后执行");

    }




    @BeforeClass
    public  void BeforeClass  (){

        System.out.println("BeforeClass：在class类运行之前执行");

    }


    @AfterClass
    public  void AfterClass  (){

        System.out.println("AfterClass：在class类运行之后执行");

    }


    //测试套件
    @BeforeSuite

    public  void BeforeSuite  (){

        System.out.println("BeforeSuite：在class运行之前运行，@BeforeClass之前，可以包含多个class");


    }


    @AfterSuite

    public  void AfterSuite  (){

        System.out.println("AfterSuite：在class运行之后运行，@AfterClass之前，可以包含多个class");

    }


/*
    BeforeSuite：在class运行之前运行，@BeforeClass之前，可以包含多个class
    BeforeClass：在class类运行之前执行
    BeforeMethod：在各个@test方法运行之前执行
            test1
    AfterMethod：在各个@test方法运行之后执行
    BeforeMethod：在各个@test方法运行之前执行
            test2
    AfterMethod：在各个@test方法运行之后执行
    AfterClass：在class类运行之后执行
    AfterSuite：在class运行之后运行，@AfterClass之前，可以包含多个class
*/

}
