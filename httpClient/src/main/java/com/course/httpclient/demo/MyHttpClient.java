package com.course.httpclient.demo;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.charset.Charset;

public class MyHttpClient {

//get 方法
    @Test
    public void test1() throws IOException {
        //存放结果
        String result;
        HttpGet get=new HttpGet("http://www.baidu.com");

    // 创建默认的httpClient实例.执行get方法
        CloseableHttpClient client = HttpClients.createDefault();


        //返回对象是response  所有新建一个HttpResponse类型的变量 response指向返回response
        HttpResponse response=client.execute(get);
        //response.getEntity() 从响应中获L:utf-8取消息实体
        // EntityUtils.toString 实体转换为字符串
        //获取当前系统编码
        result = EntityUtils.toString(response.getEntity(),Charset.defaultCharset());
        System.out.println(result);

    }


//
//    @Test
//    public void test1() throws IOException {
//
//
//        CloseableHttpClient httpclient = HttpClients.createDefault();
//        HttpGet httpGet = new HttpGet("http://www.baidu.com");
//        CloseableHttpResponse response = httpclient.execute(httpGet);
//
//    }




}

