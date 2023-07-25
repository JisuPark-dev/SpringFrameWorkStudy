package com.example.springframework.web;


import com.example.springframework.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {
    private final MyLogger myLogger;
    public void logic(String testId) {
        myLogger.log("Service id = " + testId);
    }
}
