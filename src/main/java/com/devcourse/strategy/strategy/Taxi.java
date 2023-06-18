package com.devcourse.strategy.strategy;

public class Taxi implements VehicleStrategy {
    @Override
    public void go() {
        System.out.println("택시 탑승!");
    }
}
