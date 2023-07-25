package com.example.springframework;

import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import com.example.springframework.order.Order;
import com.example.springframework.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.example.springframework.member.Grade.VIP;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", VIP);

        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("itemA = " + itemA);
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());
    }
}
