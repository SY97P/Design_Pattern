package com.devcourse.mediator.module.component;

import com.devcourse.mediator.module.mediator.Mediator;

public abstract class Unit {

    protected Mediator mediator;

    public Unit(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void sendMessage(String message);

    public abstract void receiveMessage(String message);
}
