package com.example.springframework.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}
