package com.devcourse.strategy.strategy;

public class Transportation {
    private VehicleStrategy strategy;

    public void setVehicleStrategy(VehicleStrategy strategy) {
        this.strategy = strategy;
    }

    public void decideVehicle() {
        if (strategy == null) {
            System.out.println("도보 이동!");
        } else {
            strategy.go();
        }
    }
}
