package com.devcourse.factory_method.factory_method.factory;

import com.devcourse.factory_method.factory_method.model.Transport;
import com.devcourse.factory_method.factory_method.model.Truck;

public class TruckFactory implements Factory {
    @Override
    public Transport create() {
        return new Truck();
    }
}
