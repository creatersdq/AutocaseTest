package com.course.utils;

import com.course.model.InterfaceName;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Locale;
import java.util.ResourceBundle;



//创建工具类，新建获取配置文件中的url及uri并进行拼接返回
public class ConfigFile {

    //
    public static ResourceBundle bundle=ResourceBundle.getBundle("application", Locale.CHINA);


    //入参枚举类定义好的接口.限制传入的值
    public  static  String getUrl(InterfaceName name){

        String url= bundle.getString("test.url");
        //初始化一个值不然走不下去
        String uri=null;
        String testUrl;

        if(name==InterfaceName.acceptQueryMsgPage){
            uri=bundle.getString("query.uri");
        }

        testUrl=url+uri;
        return  testUrl;

    }

}
