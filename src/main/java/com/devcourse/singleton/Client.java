package com.devcourse.singleton;

import com.devcourse.singleton.singleton.Singleton;

public class Client {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        int hashCode1 = instance1.hashCode();

        Singleton instance2 = Singleton.getInstance();
        int hashCode2 = instance2.hashCode();

        System.out.println(hashCode1 == hashCode2);
    }
}