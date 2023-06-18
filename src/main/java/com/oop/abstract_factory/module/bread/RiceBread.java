package com.oop.abstract_factory.module.bread;

public class RiceBread implements Bread {
    @Override
    public void bake() {
        System.out.println("쌀빵 굽기");
    }
}
