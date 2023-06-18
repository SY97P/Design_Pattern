package com.oop.abstract_factory.module.petties;

public class BulgogiPetties implements Petties {
    @Override
    public void grill() {
        System.out.println("불고기 패티 굽기");
    }
}
