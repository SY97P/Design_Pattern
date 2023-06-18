package com.devcourse.proxy.proxy;

public class ProxyCalculator implements Calculator {

    private Calculator realCalculator;

    @Override
    public int add(int a, int b) {
        System.out.println("프록시: 원본 객체에 작업요청 시작");

        if (realCalculator == null) {
            this.realCalculator =  new RealCalculator();
        }
        int result =  realCalculator.add(a, b);

        System.out.println("프록시: 원본 객체에서 작업결과 반환");

        return result;
    }
}
