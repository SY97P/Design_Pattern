package com.devcourse.abstract_factory.module;

import com.devcourse.abstract_factory.module.bread.Bread;
import com.devcourse.abstract_factory.module.factory.McDonaldFactory;
import com.devcourse.abstract_factory.module.petties.Petties;

public class Order {
    private final Bread bread;
    private final Petties petties;

    public Order(McDonaldFactory factory) {
        this.bread = factory.takeBread();
        this.petties = factory.takePetties();
    }

    public void cook() {
        bread.bake();
        petties.grill();
    }

}
