package com.course.server;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunHints;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description ="所有的getTestCase")
public class MyGetMethod {

    //声明方法问路径,接口访问类型（接口路径，访问类型)
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "获取cookie",httpMethod ="GET" )
    //方法名
    public  String getCookies(HttpServletResponse response){

//        HttpServletRequest  装请求信息的类
//        HttpServletResponse 装响应信息的类
        //新建一个cookie变量，存储cookie
        Cookie cookie=new Cookie("login","true");
        //将定义好的cookie添加到响应中
        response.addCookie(cookie);

        return "恭喜你获取cookie成功";

    }


//    要求客户端携带cookis访问
    @RequestMapping(value = "/getWithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "带cookie访问",httpMethod = "Get")
    public String  getWithCookies(HttpServletRequest request){

        //获取请求cookies
     Cookie[] cookies=request.getCookies();

     //无cookie判断
     if(Objects.isNull(cookies)){

         return "你必须携带cookie访问";
     }

     //有cookie判断
     for(Cookie cookie:cookies){
     if (cookie.getName().equals("login")&&cookie.getValue().equals("true"))

         return "访问成功";

     }
     return "你必须携带cookie访问";

    }


    //需要携带参数访问的get请求
    //第一种实现方式 url: ip:port/get?key=value&key=value
    //模拟获取商品列表

    //Map<String,Integer> 返回类型  key：vlue类型的Map
    //@RequestParam Integer start,@RequestParam Integer end  定义两个入参


    @RequestMapping(value = "/getList",method = RequestMethod.GET)
    @ApiOperation(value = "模拟获取商品列表接口",httpMethod = "GET")
    //map是一个数据集合
  /*  Map类型	插入是否有序	顺序特点
      HashMap	    无序	     -
      LinkedHashMap	有序	   记录插入顺序
      TreeMap	    有序  	默认升序
　　Map主要用于存储健值对，根据键得到值，因此不允许键重复（若重复则覆盖），但允许值重复。*/
    public Map<String,Integer> getList(@RequestParam Integer start,@RequestParam Integer end) {

        //定义接口返回变量 mylist
        Map<String,Integer>  mylist=new HashMap<>();
        //mylist变量赋值
        mylist.put("水果1",1000);
        mylist.put("水果2",700);
        mylist.put("水果3",8000);
        mylist.put("水果4",9000);

        return mylist;

    }

    /**
     * 第二种需要携带参数访问的get请求
     * url:ip:port/get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "get传参方法2,见到不多。暂时未做过多关注",httpMethod = "GET")
    public  Map myGetList(@PathVariable Integer start,
                          @PathVariable Integer end){

        Map<String,Integer> myList = new HashMap<>();

        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);

        return  myList;

    }

    }
