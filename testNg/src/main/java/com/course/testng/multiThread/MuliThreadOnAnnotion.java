package com.course.testng.multiThread;

import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class MuliThreadOnAnnotion {


    @Test(invocationCount = 10,threadPoolSize = 10)
/*    invocationCount 线程数
      threadPoolSize 线程池*/
        public  void test(){
        System.out.println("1");
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
        //打印线程池id
    }

}
