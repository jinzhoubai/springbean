package com.springmybatis;

import com.springmybatis.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springmybatis")
public class SpringMybaitApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringMybaitApplication.class);
        applicationContext.refresh();

        UserService userService = applicationContext.getBean("usrservice", UserService.class);
        userService.test();

    }
}
