package com.devcourse.abstract_factory.module.factory;

import com.devcourse.abstract_factory.module.bread.Bread;
import com.devcourse.abstract_factory.module.bread.WheatBread;
import com.devcourse.abstract_factory.module.petties.Petties;
import com.devcourse.abstract_factory.module.petties.SushiPetties;

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
