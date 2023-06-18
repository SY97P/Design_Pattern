package com.devcourse.adapter;

import com.devcourse.adapter.adapter.AdapterService1;
import com.devcourse.adapter.adapter.AdapterService2;

public class Client {

    public static void main(String[] args) {
        AdapterService1 as1 = new AdapterService1();
        AdapterService2 as2 = new AdapterService2();

        as1.runService();
        as2.runService();
    }

}
