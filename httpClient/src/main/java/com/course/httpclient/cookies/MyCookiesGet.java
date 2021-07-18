package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesGet {

    private String url;
    private String uri;
    private ResourceBundle bundle;
    //存储cookie信息
    private BasicCookieStore cookieStore;
    private  String result;

    @BeforeTest
    public  void beforeTest(){

    //定义bundle的值
    bundle=ResourceBundle.getBundle("application", Locale.CHINA);
    //获取配置文件的值
    url=bundle.getString("test.url");
    uri=bundle.getString("getCookies.uri");
    }



    @Test
    public void testGetCookies() throws IOException {
    //提前定义cookie变量对象 使用this.代表用的是class类下声明的私有变量，而不是局部变量
     this.cookieStore = new BasicCookieStore();
    //从配置文件拼接接口url+uri
    HttpGet get=new HttpGet(url+uri);

    //测试代码逻辑书写
    // 调用get接口
//
// 获取不到cookie   CloseableHttpClient client = HttpClients.createDefault();
    CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
    //获取响应结果
    HttpResponse response=client.execute(get);
    //获取消息实体，然后将消息实体转换为字符串类型，并被变量 result引用/指向
    this.result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
        System.out.println(result);
        //获取cookie信息
        //<>泛型
        List<Cookie> cookies = cookieStore.getCookies();
        //for语句遍历数组  遍历cookies列表-右边  返回cookie类型的 cookie字段
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies: key= "+ name + "  value= " + value);
        }

    }


    @Test(dependsOnMethods ="testGetCookies" )
    public  void testGetWithCookies() throws IOException {

        //改变引用变量uri引用内容
        uri=bundle.getString("tet.get.with.cookies");
        HttpGet get=new HttpGet(url+uri);
        CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //访问get请求
        HttpResponse response=client.execute(get);

        //获取响应状态码
        //ctrl+q查看调用方法返回参数类型
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println(statusCode);

        if (statusCode==200){

            this.result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            System.out.println(result);

        }


    }



}
