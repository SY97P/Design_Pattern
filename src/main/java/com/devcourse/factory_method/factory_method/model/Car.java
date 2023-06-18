package com.devcourse.factory_method.factory_method.model;

public class Car implements Transport {
    @Override
    public void deliver() {
        System.out.println("차로 배달");
    }
}
