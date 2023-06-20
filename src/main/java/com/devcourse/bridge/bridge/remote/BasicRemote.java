package com.devcourse.bridge.bridge.remote;

public class BasicRemote implements Remote {

    protected Device device;

    public BasicRemote() {}

    public BasicRemote(Device device) {
        this.device = device;
    }

    @Override
    public void power() {
        System.out.println("Remote: 전원 토글");
        if (device.isEnabled()) {
            device.disable();
            return;
        }
        device.enable();
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: 볼륨 낮추기");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: 볼륨 높이기");
        device.setVolume(device.getVolume() + 10);
    }
}
