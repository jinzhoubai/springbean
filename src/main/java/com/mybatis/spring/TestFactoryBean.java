package com.mybatis.spring;

import com.springmybatis.mapper.UserMapper;
import com.springmybatis.service.Person;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestFactoryBean implements FactoryBean {
    private Class mapperClass;

    public TestFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Override
    public Object getObject() throws Exception {
        Object proxyInstance = Proxy.newProxyInstance(TestFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            //代理逻辑
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        });
        return proxyInstance;

    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
