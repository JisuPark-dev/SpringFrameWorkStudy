package com.example.springframework.singleton;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.MemberServiceImpl;
import com.example.springframework.order.OrderService;
import com.example.springframework.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConfigurationSingletonTest {

     @Test
     void configurationTest(){
         //given
         ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

         OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
         MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
         //when
         
         //then
         assertThat(memberService.getMemberRepository()).isEqualTo(orderService.getMemberRepository());
         
     }

    @Test
    void configurationDeep(){
        //given
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());

    }
}
