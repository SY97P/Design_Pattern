package com.devcourse.adapter.adapter;

import com.devcourse.adapter.adapter.service.ServiceB;

public class AdapterService2 {
    ServiceB sb = new ServiceB();

    public void runService() {
        sb.runServiceB();
    }
}
