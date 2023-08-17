package com.devcourse.visitor.module.element;

import com.devcourse.visitor.module.Visitor;

public interface Element {
    void accept(Visitor visitor);
}
