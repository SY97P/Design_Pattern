package com.devcourse.bridge;

import com.devcourse.bridge.bridge.remote.*;

public class Client {
    public static void main(String[] args) {
        testDevice(new TV());
        testDevice(new Radio());
    }

    private static void testDevice(Device device) {
        System.out.println("BasicRemote 테스트");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("AdvancedRemote 테스트");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
