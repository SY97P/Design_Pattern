package com.oop.abstract_factory.module.petties;

public class SushiPetties implements Petties {
    @Override
    public void grill() {
        System.out.println("물고기 패티 굽기");
    }
}
