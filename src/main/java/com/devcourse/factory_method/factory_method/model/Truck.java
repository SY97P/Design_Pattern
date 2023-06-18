package com.devcourse.factory_method.factory_method.model;

public class Truck implements Transport {
    @Override
    public void deliver() {
        System.out.println("트럭으로 배달");
    }
}
