package com.example.springframework;

import com.example.springframework.config.AppConfig;
import com.example.springframework.member.Member;
import com.example.springframework.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static com.example.springframework.member.Grade.VIP;

public class MemberApp {
    public static void main(String[] args) {
        //AppConfig.class는 AnnotationConfigApplicationContext 생성자에 전달되는 매개변수로,
        // Spring이 IoC 컨테이너 생성 시 사용할 설정 정보를 담고 있는 클래스
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //MemberService.class -> MemberService 타입의 빈 중에서 "memberService"라는 이름의 빈을 가져오겠다.
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member member1 = new Member(1L, "jisu",VIP);
        memberService.join(member1);
        System.out.println(member1.getName());
        System.out.println(memberService.findMember(1L).getName());
    }
}
