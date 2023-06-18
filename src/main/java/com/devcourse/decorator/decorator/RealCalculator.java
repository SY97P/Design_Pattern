package com.devcourse.decorator.decorator;

public class RealCalculator implements Calculator {
    @Override
    public String addAndDecorate(int a, int b) {
        return String.valueOf(a+b);
    }
}
