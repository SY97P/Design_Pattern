package com.devcourse.abstract_factory.module.factory;

import com.devcourse.abstract_factory.module.bread.Bread;
import com.devcourse.abstract_factory.module.petties.Petties;

public interface McDonaldFactory {
    Bread takeBread();
    Petties takePetties();
}
