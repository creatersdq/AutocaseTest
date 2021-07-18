package com.course.model;


import lombok.Data;


//查询在线通知测试model类（实体类）
@Data
public class bncqueryTest {


    private String sendorgcode  ;
    private String receiveorgcode  ;
    private String content  ;
    private String accepttype ;
    private String sender;
    private String except;

}
