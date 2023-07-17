package com.example.springframework.discount;

import com.example.springframework.member.Grade;
import com.example.springframework.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.example.springframework.member.Grade.BASIC;
import static com.example.springframework.member.Grade.VIP;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Test
    @DisplayName("VIP는 10%할인이 적용된다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", VIP);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        assertEquals(discount, 2000);
    }
    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않는다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "memberVIP", BASIC);
        //when
        int discount = discountPolicy.discount(member, 20000);
        //then
        assertEquals(discount, 0);
    }

}