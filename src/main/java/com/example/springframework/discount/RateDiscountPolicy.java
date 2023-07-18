package com.example.springframework.discount;

import com.example.springframework.member.Member;

import static com.example.springframework.member.Grade.VIP;

public class RateDiscountPolicy implements DiscountPolicy{
    int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade().equals(VIP)) {
            return price * discountPercent/100;
        }
        return 0;
    }
}
