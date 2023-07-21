package com.example.springframework.discount;

import com.example.springframework.aanotation.MainDiscountPolicy;
import com.example.springframework.member.Member;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import static com.example.springframework.member.Grade.VIP;
@Component
@MainDiscountPolicy
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
