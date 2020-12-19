package com.springmybatis;

import com.mybatis.spring.BeanDefinitionRegister;
import com.mybatis.spring.TestFactoryBean;
import com.springmybatis.mapper.UserMapper;
import com.springmybatis.service.User;
import com.springmybatis.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@ComponentScan("com.springmybatis")
@Import(BeanDefinitionRegister.class)
public class SpringMybaitApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringMybaitApplication.class);





        applicationContext.refresh();

//        System.out.println(applicationContext.getBean("user"));
//        System.out.println(applicationContext.getBean("&user"));

        UserService userService = applicationContext.getBean("user", UserService.class);
        userService.test();

    }
}
