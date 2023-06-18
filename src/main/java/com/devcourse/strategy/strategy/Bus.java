package com.devcourse.strategy.strategy;

public class Bus implements VehicleStrategy {
    @Override
    public void go() {
        System.out.println("버스 탑승!");
    }
}
