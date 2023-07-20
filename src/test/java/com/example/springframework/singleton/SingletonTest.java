package com.example.springframework.singleton;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SingletonTest {
    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        // 1. 조회 : 호출할 때마다 객체 생성
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        //참조 값이 다른 것을 확인
        assertNotEquals(memberService1, memberService2);
    }

    @Test
    @DisplayName("스프링 있는")
    void springContainer() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 1. 조회 : 호출할 때마다 객체 생성
        MemberService memberService1 = applicationContext.getBean("memberService", MemberServiceImpl.class);
        MemberService memberService2 = applicationContext.getBean("memberService", MemberServiceImpl.class);

        //참조 값이 다른 것을 확인
        assertEquals(memberService1, memberService2);
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체")
    void singletonTest2(){
        //given
        SingletonService instance1 = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();
        //when
        
        //then
        assertEquals(instance1, instance2);
        
    }
}
