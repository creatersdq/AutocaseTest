package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class groupOnMethod {


    @Test(groups="service")

    public void test1(){
        System.out.println("1.1");


    }

    @Test(groups="service")

    public void test2(){

        System.out.println("1.2");
    }


    @Test(groups="httpclint")

    public void test3(){
        System.out.println("2.1");

    }

    @Test(groups="httpclint")

    public void test4(){
        System.out.println("2.2");

    }

    @BeforeGroups("service")

    public void BeforeGroups(){

        System.out.println("BeforeGroups");
    }


    @AfterGroups("service")
    public void AfterGroups(){
        System.out.println("AfterGroups");

    }

    @BeforeGroups("httpclint")

    public void BeforeGroups2(){
        System.out.println("BeforeGroups2");
    }


    @AfterGroups("httpclint")
    public void AfterGroups2(){
        System.out.println("AfterGroups2");

    }



}
