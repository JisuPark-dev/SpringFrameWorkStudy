package com.example.springframework;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import com.example.springframework.order.Order;
import com.example.springframework.order.OrderService;

import static com.example.springframework.member.Grade.VIP;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", VIP);

        memberService.join(member);

        Order itemA = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("itemA = " + itemA);
        System.out.println("itemA.calculatePrice() = " + itemA.calculatePrice());
    }
}
