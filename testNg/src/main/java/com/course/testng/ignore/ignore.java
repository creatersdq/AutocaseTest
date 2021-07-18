package com.course.testng.ignore;

import jdk.nashorn.internal.objects.annotations.ScriptClass;
import org.testng.annotations.Test;

public class ignore {

    @Test(enabled = false)
    public   void  ignore1(){
        System.out.println("enabled属性为false时，忽略不执行");
    }

    @Test(enabled = true)
    public   void  ignore2(){
        System.out.println("enabled属性默认为true，执行");
    }

}
