package com.springmybatis;

import com.mybatis.spring.BeanDefinitionRegister;
import com.mybatis.spring.TestFactoryBean;
import com.mybatis.spring.TestScan;
import com.springmybatis.mapper.UserMapper;
import com.springmybatis.service.User;
import com.springmybatis.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import sun.security.tools.policytool.Resources_ko;

import java.io.IOException;
import java.io.InputStream;

@ComponentScan("com.springmybatis")
@TestScan("springmybatis.mapper")
public class SpringMybaitApplication {
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory;


    }
    public static void main(String[] args) {


        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringMybaitApplication.class);


        applicationContext.refresh();

//        System.out.println(applicationContext.getBean("user"));
//        System.out.println(applicationContext.getBean("&user"));

//        UserService userService = applicationContext.getBean("user", UserService.class);
//        userService.test();

    }
}
