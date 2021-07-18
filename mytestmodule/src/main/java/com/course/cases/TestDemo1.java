package com.course.cases;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.course.config.TestConfig;
import com.course.model.InterfaceName;
import com.course.model.bnc_msg;
import com.course.model.bncqueryTest;
import com.course.utils.ConfigFile;
import com.course.utils.DataBasicUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestDemo1 {


    @BeforeTest(groups="bnc",description = "测试前的准备工作")
    public  void BeforeTest(){

        //配置类变量  调用工具类读取application.properties中数据并进行拼接  并给配置类变量赋值
        //给调用接口路径赋值
        TestConfig.acceptQueryMsgPage= ConfigFile.getUrl(InterfaceName.acceptQueryMsgPage);

        //HTTPCLIENT赋值
        TestConfig.client= HttpClients.custom().setDefaultCookieStore(TestConfig.cookieStore).build();

    }



    @Test(groups = "bnc",description = "")
    public  void  test1() throws IOException {

        //创建sqlsession对象
        SqlSession session= DataBasicUtils.getSqlSession();
        //查询用例表 获取用例orgcode
        bncqueryTest querytest=session.selectOne("acceptQueryMsgPageCase",1);

        List<bnc_msg> bnc_msg=session.selectList(querytest.getExcept(),querytest.getReceiveorgcode());


        //遍历数组  bnc_msg  bnc_msg
//        for(bnc_msg u : bnc_msg){
//            System.out.println("list获取的user:"+u.toString());
//        }

        //期望结果
        JSONArray except = new JSONArray(bnc_msg);

        System.out.println(except.get(0));
        System.out.println(except.get(1));

        //实际结果
        JSONArray result=getresult(querytest);

//        System.out.println("resultJson: "+result);
//        此时断言可能是fail，因为这时两个json返回字段默认顺序不一定相同
//        Assert.assertEquals(except,result);

//        在对应model实体类中重写toString方法，将json数组字段按照相同顺序排序，这时应该是返回true的
//        Assert.assertEquals(except.toString(),result.toString());

//
        Assert.assertEquals(result.length(),except.length());
        for(int i = 0;i<result.length();i++){
            JSONObject expect = (JSONObject) result.get(i);
            System.out.println(i+":"+except.toString());
            JSONObject actual = (JSONObject) except.get(i);
            System.out.println(i+":"+actual.toString());


            String expectvalue=(String) expect.get("send_user_name");
            System.out.println("expectvalue"+":"+expectvalue);
            String actualvalue=(String) actual.get("send_user_name");
            System.out.println("actualvalue"+":"+actualvalue);
            Assert.assertEquals(expectvalue, actualvalue);


            String expectcontext=(String) expect.get("context");
            System.out.println("expectcontext"+":"+expectcontext);
            String actualcontext=(String) actual.get("context");
            System.out.println("actualcontext"+":"+actualcontext);
            Assert.assertEquals(actualcontext, actualcontext);
        }

    }


    //通过httpclient调用接口获取响应结果
    public JSONArray getresult(bncqueryTest receiveorgcode) throws IOException {

        //创建post方法对象
        HttpPost post=new HttpPost(TestConfig.acceptQueryMsgPage);
        //创建json对象
        JSONObject param=new JSONObject();
        param.put("receive_org_code",receiveorgcode.getReceiveorgcode());
        //设置请求头header
        post.setHeader("content-type","application/json");
        //将JSON参数转换为字符串实体
        StringEntity entity=new StringEntity(param.toString(),"UTF-8");
        //将参数信息添加到方法中
        post.setEntity(entity);
/*
        //设置cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);*/
        //声明一个对象来进行响应结果的存储
        String result;
        //执行post方法
        //1 创建httpclient对象
        BasicCookieStore cookieStore=new BasicCookieStore();
        CloseableHttpClient client=HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        //2 通过httpclient执行post方法并获取响应结果
        HttpResponse response=client.execute(post);
        //3 获取消息实体，然后将消息实体转换为字符串类型，并被变量 result引用/指向
        result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
//        System.out.println("result: "+result);
        //转换为json数组
        JSONArray jsonResult=new JSONArray(result);
        return jsonResult;
    }


//    @Test
//    public  void test() throws IOException {
//
//        bncqueryTest oo=new bncqueryTest();
//        oo.setReceiveorgcode("W12000301051002");
//        JSONArray JJ=getresult(oo);
//        System.out.println(JJ);
//
//    }
}
