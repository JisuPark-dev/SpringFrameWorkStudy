package com.example.springframework.config;

import com.example.springframework.discount.DiscountPolicy;
import com.example.springframework.discount.FixDiscountPolicy;
import com.example.springframework.discount.RateDiscountPolicy;
import com.example.springframework.member.MemberRepository;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;
import com.example.springframework.member.MemoryMemberRepository;
import com.example.springframework.order.OrderService;
import com.example.springframework.order.OrderServiceImpl;

public class AppConfig {
    //생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
