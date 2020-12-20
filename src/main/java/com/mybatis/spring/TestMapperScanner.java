package com.mybatis.spring;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.TypeFilter;

public class TestMapperScanner extends ClassPathBeanDefinitionScanner {

    public TestMapperScanner(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
        return beanDefinition.getMetadata().isInterface();
    }

    @Override
    public void addIncludeFilter(TypeFilter includeFilter) {
        super.addIncludeFilter(includeFilter);
    }
}
