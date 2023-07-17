package com.example.springframework.discount;

import com.example.springframework.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
