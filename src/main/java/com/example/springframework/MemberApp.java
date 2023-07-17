package com.example.springframework;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import com.example.springframework.member.MemberServiceImpl;

import static com.example.springframework.member.Grade.VIP;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member1 = new Member(1L, "jisu",VIP);
        memberService.join(member1);
        System.out.println(member1.getName());
        System.out.println(memberService.findMember(1L).getName());
    }
}
