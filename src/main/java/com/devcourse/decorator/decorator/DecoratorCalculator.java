package com.devcourse.decorator.decorator;

public class DecoratorCalculator implements Calculator {

    private Calculator realCalculator;

    @Override
    public String addAndDecorate(int a, int b) {
        System.out.println("프록시: 원본 객체에 작업요청 시작");

        if (realCalculator == null) {
            this.realCalculator =  new RealCalculator();
        }
        String result = realCalculator.addAndDecorate(a, b);

        System.out.println("프록시: 원본 객체에서 작업결과 반환");

        return "결과는 " + result;
    }
}
