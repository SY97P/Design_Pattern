package com.devcourse.templete_method;

import com.devcourse.templete_method.templete.Animal;
import com.devcourse.templete_method.templete.Cat;
import com.devcourse.templete_method.templete.Dog;

public class Client {
    public static void main(String[] args) {
        Animal bolt = new Dog();
        Animal kitty = new Cat();

        bolt.playWithOwner();

        System.out.println();

        kitty.playWithOwner();
    }
}
