package com.devcourse.strategy;

import com.devcourse.strategy.strategy.Bus;
import com.devcourse.strategy.strategy.Taxi;
import com.devcourse.strategy.strategy.Transportation;

public class Client {
    public static void main(String[] args) {
        Transportation transportation = new Transportation();
        transportation.decideVehicle();

        transportation.setVehicleStrategy(new Bus());
        transportation.decideVehicle();

        transportation.setVehicleStrategy(new Taxi());
        transportation.decideVehicle();
    }
}