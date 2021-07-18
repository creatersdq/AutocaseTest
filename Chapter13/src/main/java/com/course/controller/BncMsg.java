package com.course.controller;


import com.course.model.BncMsgEntity;
import com.course.model.BncMsgParaEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.annotations.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Log4j
@RestController
@Api(value = "bncmessage",description = "在线通知接口")
@RequestMapping("bncmessage")
public class BncMsg {


    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    //注释,swaggerui会用到
    @ApiOperation(value = "查询在线通知列表接口",httpMethod = "POST")
    //访问路径
    @RequestMapping(value = "/acceptQueryMsgPage",method = RequestMethod.POST)
    public List<BncMsgEntity> acceptQueryMsgPage(HttpServletRequest request,
                                                 HttpServletResponse response,
                                                 @RequestBody BncMsgParaEntity receive_org_code){

        //根据部门编码查询在线通知列表
        List<BncMsgEntity> resultLists = template.selectList("resultLists",receive_org_code);
        //记录日志
        log.info("查询成功");
        return resultLists;
    }

}
