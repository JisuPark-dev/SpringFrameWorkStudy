package com.example.springframework.member;

import com.example.springframework.config.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.convert.DataSizeUnit;

import static com.example.springframework.member.Grade.VIP;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("memberJoinTest")
    void memberJoinTest(){
        //given
        Member member = new Member(1L, "jisu", VIP);
        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        //then
        assertEquals(member.getName(), findMember.getName());
    }

}