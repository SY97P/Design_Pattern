package com.oop.abstract_factory.module.factory;

import com.devcourse.module.bread.Bread;
import com.devcourse.module.bread.WheatBread;
import com.devcourse.module.petties.Petties;
import com.devcourse.module.petties.SushiPetties;

public class JapanMcDonaldFactory implements McDonaldFactory {
    @Override
    public Bread takeBread() {
        return new WheatBread();
    }

    @Override
    public Petties takePetties() {
        return new SushiPetties();
    }
}
