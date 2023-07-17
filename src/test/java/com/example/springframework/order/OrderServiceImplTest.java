package com.example.springframework.order;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.Grade;
import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.example.springframework.member.Grade.VIP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(order.calculatePrice()).isEqualTo(9000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
        
    }

}