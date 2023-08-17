package com.devcourse.visitor;

import com.devcourse.visitor.module.Shopper;
import com.devcourse.visitor.module.element.Cart;

public class Client {
    public static void main(String[] args) {
        Shopper shopper = new Shopper();
        Cart cart = new Cart();
        cart.accept(shopper);
    }
}
