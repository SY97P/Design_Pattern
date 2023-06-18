package com.devcourse.abstract_factory.module.factory;

import com.devcourse.abstract_factory.module.bread.Bread;
import com.devcourse.abstract_factory.module.bread.RiceBread;
import com.devcourse.abstract_factory.module.petties.BulgogiPetties;
import com.devcourse.abstract_factory.module.petties.Petties;

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
