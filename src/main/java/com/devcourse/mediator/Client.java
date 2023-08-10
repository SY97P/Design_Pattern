package com.devcourse.mediator;

import com.devcourse.mediator.module.component.FireFighter;
import com.devcourse.mediator.module.component.Police;
import com.devcourse.mediator.module.component.Unit;
import com.devcourse.mediator.module.mediator.CommandCenter;
import com.devcourse.mediator.module.mediator.Mediator;

public class Client {

    static Mediator mediator;

    static Unit police;
    static Unit fireFighterA;
    static Unit fireFighterB;

    public static void main(String[] args) {
        setup();

        ignition();
        extinguishing();
        extinguished();
    }

    private static void ignition() {
        police.sendMessage("불 났다!");
        System.out.println();
    }

    private static void extinguishing() {
        police.sendMessage("집 간다!");
        mediator.deleteUnit(police);
        System.out.println();
    }

    private static void extinguished() {
        fireFighterA.sendMessage("불 껐다!");
        System.out.println();
    }

    private static void setup() {
        mediator = new CommandCenter();

        police = new Police(mediator, "0");
        fireFighterA = new FireFighter(mediator, "A");
        fireFighterB = new FireFighter(mediator, "B");

        mediator.addUnit(police);
        mediator.addUnit(fireFighterA);
        mediator.addUnit(fireFighterB);
    }

}

