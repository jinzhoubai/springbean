package com.mybatis.spring;

import com.springmybatis.service.Person;
import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Person person = new Person();
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
