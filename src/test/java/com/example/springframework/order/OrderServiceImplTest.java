package com.example.springframework.order;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.example.springframework.member.Grade.VIP;
import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceImplTest {
    MemberService memberService;
    OrderService orderService;
    @BeforeEach
    public void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    
    @Test
    void createOrder(){
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", VIP);
        memberService.join(member);
        //when
        Order order = orderService.createOrder(memberId, "itemA", 20000);

        //then
        assertThat(order.calculatePrice()).isEqualTo(18000);
        assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }
}