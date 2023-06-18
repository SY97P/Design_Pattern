package com.devcourse.factory_method;

import com.devcourse.factory_method.factory_method.factory.CarFactory;
import com.devcourse.factory_method.factory_method.factory.Factory;
import com.devcourse.factory_method.factory_method.factory.TruckFactory;
import com.devcourse.factory_method.factory_method.model.Transport;

public class Client {
    public static void main(String[] args) {
        Factory carFactory = new CarFactory();
        Factory truckFactory = new TruckFactory();

        Transport car = carFactory.create();
        Transport truck = truckFactory.create();

        car.deliver();
        truck.deliver();

    }
}