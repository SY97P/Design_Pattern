package com.devcourse.templete_method.templete;

public class Dog extends Animal {
    @Override
    // 추상 메소드 오버라이딩
    void play() {
        System.out.println("멍! 멍!");
    }

    @Override
    // 훅 메소드 오버라이딩 (해도되고 안 해도 되고)
    void runSomething() {
        System.out.println("멍! 멍! 꼬리 살랑살랑~~");
    }
}
