package com.course.testng.groups;

import org.testng.annotations.Test;


@Test(groups = "student")
public class groupsOnClass1 {

    public void stu1(){

        System.out.println("stu1");
    }

    public void stu2(){

        System.out.println("stu2");

    }
}
