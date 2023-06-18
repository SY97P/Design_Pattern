package com.devcourse.adapter.adapter;

import com.devcourse.adapter.adapter.service.ServiceA;

public class AdapterService1 {
    ServiceA sa = new ServiceA();

    public void runService() {
        sa.runServiceA();
    }
}
