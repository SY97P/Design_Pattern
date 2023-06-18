package com.devcourse.factory_method.factory_method.factory;

import com.devcourse.factory_method.factory_method.model.Car;
import com.devcourse.factory_method.factory_method.model.Transport;

public class CarFactory implements Factory {
    @Override
    public Transport create() {
        return new Car();
    }
}
