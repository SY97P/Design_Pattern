package com.devcourse.proxy;

import com.devcourse.proxy.proxy.Calculator;
import com.devcourse.proxy.proxy.ProxyCalculator;

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new ProxyCalculator();
        int sum = calculator.add(2, 3);
        System.out.println(sum);
    }
}