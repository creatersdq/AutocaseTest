package com.course.bean;

import lombok.Data;


//json格式
@Data
public class User {
    private String userName;
    private String password;
    private String name;
    private String age;
    private String sex;
}
