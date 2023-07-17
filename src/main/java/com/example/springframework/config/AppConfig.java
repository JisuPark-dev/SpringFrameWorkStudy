package com.example.springframework.config;

import com.example.springframework.discount.FixDiscountPolicy;
import com.example.springframework.discount.RateDiscountPolicy;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;
import com.example.springframework.member.MemoryMemberRepository;
import com.example.springframework.order.OrderService;
import com.example.springframework.order.OrderServiceImpl;

public class AppConfig {
    //생성자 주입
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                new MemoryMemberRepository(),
                new RateDiscountPolicy()
        );
    }

}
