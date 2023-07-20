package com.example.springframework.singleton;

import com.example.springframework.member.MemberService;
import org.junit.jupiter.api.Test;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("SingletonService.logic");
    }
}
