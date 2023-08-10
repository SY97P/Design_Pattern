package com.devcourse.abstract_factory;

import com.devcourse.abstract_factory.module.Nation;
import com.devcourse.abstract_factory.module.Order;
import com.devcourse.abstract_factory.module.factory.JapanMcDonaldFactory;
import com.devcourse.abstract_factory.module.factory.KoreanMcDonaldFactory;
import com.devcourse.abstract_factory.module.factory.McDonaldFactory;

public class Client {
    public static void main(String[] args) {
        Order order = makeOrder(Nation.JP);
        order.cook();
    }

    private static Order makeOrder(Nation nation) {
        if (nation.equals(Nation.JP)) {
            McDonaldFactory factory = new JapanMcDonaldFactory();
            return new Order(factory);
        }
        return new Order(new KoreanMcDonaldFactory());
    }
}