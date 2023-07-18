package com.example.springframework.beanfind;

import com.example.springframework.config.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    @Test
    @DisplayName("모든 빈 출력하")
    void findAllBean(){
        //given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //when
        //then
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("bean = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하")
    void findApplicationBean(){
        //given
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        //when
        //then
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = "+beanDefinitionName + " bean = " + bean);
            }
        }
    }
}
