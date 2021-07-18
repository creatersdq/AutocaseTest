package com.course.utils;

import com.course.model.LoginCase;
import com.course.model.bnc_msg;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;
import java.io.IOException;
import java.io.Reader;


//新建一个配置类方法，用来获取数据库对象
public class DataBasicUtils {




    public static SqlSession getSqlSession() throws IOException {

        //获取配置的资源文件，后面跟上根目录上配置xml文件
        Reader reader= Resources.getResourceAsReader("databaseConfig.xml");
        //加载配置文件
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
        //sqlsession可以执行配置文件中的sql文件
        SqlSession sqlSession=factory.openSession();
        return sqlSession;
    }

//    @Test
//
//    public void   testcase1() throws IOException {
//        SqlSession session=getSqlSession();
//        LoginCase loginCase = session.selectOne("loginCase",2);
//        System.out.println(loginCase);
//
//    }



}


