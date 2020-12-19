package com.springmybatis;

import com.mybatis.spring.TestFactoryBean;
import com.springmybatis.service.User;
import com.springmybatis.service.UserService;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.springmybatis")
public class SpringMybaitApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(SpringMybaitApplication.class);



        //获取BeanDefinition对象
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();

        beanDefinition.setBeanClass(TestFactoryBean.class);
        applicationContext.registerBeanDefinition("user", beanDefinition);
        applicationContext.refresh();
        System.out.println(applicationContext.getBean("user"));
        System.out.println(applicationContext.getBean("&user"));

//        UserService userService = applicationContext.getBean("usrservice", UserService.class);
//        userService.test();

    }
}
