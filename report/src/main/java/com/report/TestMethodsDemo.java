package com.report;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

//踩坑记录，class名第一个字母要大写，不然测试报告HTML文件会生产失败。。。。。

public class TestMethodsDemo {


    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }


    @Test
    public void test3(){
        Assert.assertEquals("aaa","aaa");
    }


    @Test
    public void logDemo(){
        Reporter.log("这是我们自己写的日志");
        throw new RuntimeException("这是我自己的运行时异常1807");
    }


}
