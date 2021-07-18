package com.course.config;


import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.testng.annotations.Test;

//创建接口变量，用于创建工具类使用  获取拼接的url+uri
public class TestConfig {


//    一般固定的值使用变量类型使用静态变量  修饰符  publuic  static


    //提前定义好变量名，变量类型，测试类clas直接调用就行了 TestConfig.acceptQueryMsgPage
    //接口地址
    public static  String  acceptQueryMsgPage;
    //提前定义httpclint对象
    public static CloseableHttpClient client;
    //定义好cookiestore
    public static BasicCookieStore cookieStore;


    @Test
    public void test(){


        System.out.println("acceptQueryMsgPage");
    }


}

