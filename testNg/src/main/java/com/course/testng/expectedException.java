package com.course.testng;

import org.testng.annotations.Test;

public class expectedException {

/*
    什么时候用到异常测试？
    当我们期望结果为一个异常的时候
    比如传参异常时，我们期待程序抛出一个异常*/

    @Test(expectedExceptions = RuntimeException.class)
    //判断是否运行中抛出异常，有则通过，没有则失败
    public void runTimeExceptionSuccess() {

//        程序抛出异常
     throw new RuntimeException();

    }


    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFailed(){


    }


}
