package com.devcourse.visitor.module.element;

import com.devcourse.visitor.module.Visitor;

public class Snack implements Element {
    @Override
    public void accept(Visitor visitor) {
        System.out.println("우유가 준비되었습니다.");
        visitor.visit(this);
    }
}
