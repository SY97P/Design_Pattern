package com.devcourse.mediator.module.component;

import com.devcourse.mediator.module.mediator.Mediator;

public class Police extends Unit {

    private final String unitName;

    public Police (Mediator mediator, String name) {
        super(mediator);
        this.unitName = "경찰"+name;
    }

    @Override
    public void sendMessage(String message) {
        System.out.println(this.unitName + ": 메시지 전송 -> " + this.unitName + " " + message);
        mediator.sendMessage(this, message);
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(this.unitName + ": 메시지 수신 -> " + message);
    }
}
