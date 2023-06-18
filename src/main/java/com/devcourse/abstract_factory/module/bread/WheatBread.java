package com.devcourse.abstract_factory.module.bread;

public class WheatBread implements Bread {
    @Override
    public void bake() {
        System.out.println("밀빵 굽기");
    }
}
