package com.devcourse.policy.policy.rule;

import com.devcourse.policy.policy.PurchaseHistory;

public class ReturnRateRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(PurchaseHistory history) {
        return history.getReturnRate() <= 0.001;
    }
}
