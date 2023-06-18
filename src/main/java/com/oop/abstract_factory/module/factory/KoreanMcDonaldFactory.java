package com.oop.abstract_factory.module.factory;

import com.devcourse.module.bread.Bread;
import com.devcourse.module.bread.RiceBread;
import com.devcourse.module.petties.BulgogiPetties;
import com.devcourse.module.petties.Petties;

public class KoreanMcDonaldFactory implements McDonaldFactory {

    @Override
    public Bread takeBread() {
        return new RiceBread();
    }

    @Override
    public Petties takePetties() {
        return new BulgogiPetties();
    }
}
