package com.devcourse.visitor.module.element;

import com.devcourse.visitor.module.Visitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cart implements Element {

    List<Element> cart = new ArrayList<>();

    public Cart() {
        cart.add(new Snack());
        cart.add(new Milk());
    }


    @Override
    public void accept(Visitor visitor) {
        System.out.println("카드가 준비되었습니다.");
        visitor.visit(this);

        cart.forEach(element -> element.accept(visitor));
    }
}
