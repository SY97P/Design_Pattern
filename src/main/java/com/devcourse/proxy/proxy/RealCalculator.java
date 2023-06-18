package com.devcourse.proxy.proxy;

public class RealCalculator implements Calculator {
    @Override
    public int add(int a, int b) {
        return a+b;
    }
}
