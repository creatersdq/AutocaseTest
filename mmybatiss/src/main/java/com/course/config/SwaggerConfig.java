package com.course.config;


//斯外葛Swagger
//书写配置文件

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//配置文件注解，spring启动时会自动加载这个注解下的class
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    //固定格式
    @Bean
    public Docket api(){
        return  new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .pathMapping("/")
                .select()
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    private ApiInfo apiInfo(){

        return new ApiInfoBuilder().title("我的接口文档")
                .contact(new Contact("sundaqing","","sundaqing0221@126.com"))
                .version("1.0.1")
                .build();

    }

}
