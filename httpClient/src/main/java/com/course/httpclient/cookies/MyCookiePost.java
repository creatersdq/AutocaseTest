package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiePost {

    //域名
    private String url;
    //路径
    private String uri;
    private ResourceBundle bundle;
    //存储cookie信息
    private BasicCookieStore cookieStore;
    //返回结果
    private  String result;

    @BeforeTest
    public  void beforeTest(){

        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
        uri=bundle.getString("getCookies.uri");

    }


    //使用get方法获取cookie，实际工作上可以调一个登录接口，为后续测试类的依赖测试方法
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
        CloseableHttpClient client= HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //获取返回消息实体
        HttpResponse response=client.execute(get);
        //将消息实体转换为字符串类型，变被变量 result引用/指向
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




    //依赖获取cookie的接口
    @Test(dependsOnMethods ={"testGetCookies"})

    public void testPoseMethod() throws IOException {
        this.uri=bundle.getString("test.post.with.cookies");
        String testUrl=this.url +this.uri;
        //创建HttpClient对象
        CloseableHttpClient client= HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //创建HttpPost对象，将要请求的URL通过构造方法传入HttpPost对象。
        HttpPost post=new HttpPost(testUrl);
        //添加json参数
        JSONObject  param=new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头信息,设置header
        post.setHeader("content-type","application/json");
        StringEntity entity=new StringEntity(param.toString(),"utf-8");
        //调用setEntity(HttpEntity entity)方法来设置请求参数。
        post.setEntity(entity);

        //声明一个对象存储结果
        //设置cookies信息
        //执行post方法
        HttpResponse response=client.execute(post);
        //获取响应信息
        //getEntity（） 获取实体
        this.result=EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(this.result);

        //处理结果，断言与预期的响应结果
        //将响应结果字符串转换为json对象
        JSONObject resultJson=new JSONObject(this.result);

        //具体判断返回结果的值
        String success=(String) resultJson.get("huhansan");
        String status=(String) resultJson.get("status");

        //根据获取到的具体值进行最后的判断
        Assert.assertEquals(success,"success");
        Assert.assertEquals(status,"1");


    }
}
