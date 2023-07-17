package com.example.springframework.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long memberId);
}
