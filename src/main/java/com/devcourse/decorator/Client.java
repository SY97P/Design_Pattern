package com.devcourse.decorator;

import com.devcourse.decorator.decorator.Calculator;
import com.devcourse.decorator.decorator.DecoratorCalculator;

public class Client {
    public static void main(String[] args) {
        Calculator calculator = new DecoratorCalculator();
        String sum = calculator.addAndDecorate(2, 3);
        System.out.println(sum);
    }
}