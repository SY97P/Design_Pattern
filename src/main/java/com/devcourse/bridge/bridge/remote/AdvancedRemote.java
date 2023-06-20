package com.devcourse.bridge.bridge.remote;

public class AdvancedRemote extends BasicRemote {
    public AdvancedRemote(Device device) {
        super(device);
    }

    public void mute() {
        System.out.println("Remote: 음소거");
        device.setVolume(0);
    }
}
