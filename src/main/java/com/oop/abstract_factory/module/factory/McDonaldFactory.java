package com.oop.abstract_factory.module.factory;

import com.devcourse.module.bread.Bread;
import com.devcourse.module.petties.Petties;

public interface McDonaldFactory {
    Bread takeBread();
    Petties takePetties();
}
