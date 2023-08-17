package com.devcourse.visitor.module;

import com.devcourse.visitor.module.element.Cart;
import com.devcourse.visitor.module.element.Milk;
import com.devcourse.visitor.module.element.Snack;

public interface Visitor {
    void visit(Cart cart);
    void visit(Snack snack);
    void visit(Milk milk);
}
