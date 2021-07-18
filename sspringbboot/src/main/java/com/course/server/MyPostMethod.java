package com.course.server;

import com.course.bean.User;
import com.course.bean.UserOfMe;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Policy;
import java.util.HashMap;
import java.util.Map;

@RestController
@Api(value = "/",description = "post请求demo集合")
@RequestMapping("/v1.0")
public class MyPostMethod {

    //声明Cookie变量
    private Cookie cookie;
    //用户成功登录获取cookie
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录获取cookies",httpMethod ="POST" )
    public  String login(HttpServletResponse response,
                         HttpServletRequest request,
                         //定义登录方法入参
                         @RequestParam(value = "userName",required = true) String username,
                         @RequestParam(value = "passWord",required = true) String password){


        if(username.equals("zhangsan")&&password.equals("12345678")){

            //写入cookies并添加发到response
            this.cookie=new Cookie("login","true");
            response.addCookie(this.cookie);
            return "恭喜你登录成功";
        }
        return  "请输入正确的账户名密码";
    }


    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ApiOperation(value = "获取商品列表",httpMethod = "post")
    public String getList (HttpServletRequest request,
                        HttpServletResponse response,
                           @RequestBody User u){

        User user;
        Cookie[] cookies=request.getCookies();
        //获取cookie
        for(Cookie c:cookies){
            if(
               c.getName().equals("login")
               &&c.getValue().equals("true")
               &&u.getUserName().equals("zhangsan")) {

                user = new User();
                user.setName("lisi");
                user.setAge("18");
                user.setSex("man");
                return  user.toString();

//                UserOfMe user=new UserOfMe();
//                Map<String,Integer>  mylist=new HashMap<>();
//                mylist.put("zhangsan",15);
//                mylist.put("lisi",15);
//                mylist.put("wangwu",14);
//                mylist.put("luliu",16);
//                return  mylist.toString();

//                user.setAge("15");
//                user.setName("lisi");
//                user.setSex("男");

            }
           }
        //验证cookie
        return "数据查询异常";
    }
}
