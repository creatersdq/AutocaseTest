package com.course.testng;

import org.omg.CORBA.TIMEOUT;
import org.testng.annotations.Test;

public class TimeOut {


    @Test(timeOut = 3000)
    //设置超时时间   注解
    public  void  timeSuccess() throws InterruptedException {
        Thread.sleep(2000);

    }

    @Test(timeOut = 2000)
    public  void  timeFailed() throws InterruptedException {
        Thread.sleep(2000);

    }
}
