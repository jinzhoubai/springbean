package com.mybatis.spring;

import com.springmybatis.mapper.MemberMapper;
import com.springmybatis.mapper.OrderMapper;
import com.springmybatis.mapper.UserMapper;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.awt.image.ImageConsumer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
  /*  @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        //获取BeanDefinition对象
        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();

        beanDefinition.setBeanClass(TestFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
        registry.registerBeanDefinition("user", beanDefinition);

    }*/

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {

        String path = "springmybatis.mapper";
        TestMapperScanner scanner = new TestMapperScanner(registry);
        scanner.addIncludeFilter(new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return true;
            }
        });
        int scan = scanner.scan(path);
        System.out.println(scan);
//        1、扫描路径 2、怎么扫

//        List<Class> mapprlist=new ArrayList<>();
//        mapprlist.add(UserMapper.class);
//        mapprlist.add(OrderMapper.class);
//        mapprlist.add(MemberMapper.class);
//
//
//        for (Class mapper : mapprlist) {
//            AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//            beanDefinition.setBeanClass(TestFactoryBean.class);
//            beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(mapper);
//            registry.registerBeanDefinition("user", beanDefinition);
//        }
//
//
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition.setBeanClass(TestFactoryBean.class);
//        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(UserMapper.class);
//        registry.registerBeanDefinition("user", beanDefinition);
//
//        AbstractBeanDefinition beanDefinition1 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition1.setBeanClass(TestFactoryBean.class);
//        beanDefinition1.getConstructorArgumentValues().addGenericArgumentValue(OrderMapper.class);
//        registry.registerBeanDefinition("user1", beanDefinition1);
//
//        AbstractBeanDefinition beanDefinition2 = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        beanDefinition2.setBeanClass(TestFactoryBean.class);
//        beanDefinition2.getConstructorArgumentValues().addGenericArgumentValue(MemberMapper.class);
//        registry.registerBeanDefinition("user2", beanDefinition2);
    }
}
