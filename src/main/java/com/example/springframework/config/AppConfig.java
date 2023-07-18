package com.example.springframework.config;

import com.example.springframework.discount.DiscountPolicy;
import com.example.springframework.discount.RateDiscountPolicy;
import com.example.springframework.member.MemberRepository;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;
import com.example.springframework.member.MemoryMemberRepository;
import com.example.springframework.order.OrderService;
import com.example.springframework.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //생성자 주입
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }
    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
