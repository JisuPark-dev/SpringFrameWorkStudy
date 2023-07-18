package com.example.springframework.beanfind;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.MemberRepository;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemoryMemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이면 오류가 난다.")
    void findSameTypeBeans() {
        //given
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(MemberRepository.class));
//        MemberRepository bean = ac.getBean(MemberRepository.class);
//        System.out.println("bean = " + bean);
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상이면 이름을 지정해주면 된다.")
    void findSameTypeBeans2() {
        //given
        MemberRepository bean = ac.getBean("memberRepository1",MemberRepository.class);
        System.out.println("bean = " + bean);
    }
    
    @Test
    void findSameTypeBean3(){
        //given
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        //when
        //then
        System.out.println("beansOfType = " + beansOfType);
        
    }
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
