package com.mybatis.spring;

import com.springmybatis.mapper.UserMapper;
import com.springmybatis.service.Person;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestFactoryBean implements FactoryBean {
    private Class mapperClass;
    private SqlSession sqlSession;

    public TestFactoryBean(Class mapperClass) {
        this.mapperClass = mapperClass;
    }

    @Autowired
    public void setSqlSession(SqlSessionFactory sqlSessionFactory) {
        sqlSessionFactory.getConfiguration().addMapper(mapperClass);
        this.sqlSession = sqlSessionFactory.openSession();
    }

    @Override
    public Object getObject() throws Exception {
//        Object proxyInstance = Proxy.newProxyInstance(TestFactoryBean.class.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
//            //代理逻辑
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
//        return proxyInstance;
        return sqlSession.getMapper(mapperClass);


    }

    @Override
    public Class<?> getObjectType() {
        return mapperClass;
    }
}
