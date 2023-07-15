package com.devcourse.policy.policy.rule;

import com.devcourse.policy.policy.PurchaseHistory;

public class PurchaseFrequencyRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(PurchaseHistory history) {
        return history.getPurchaseFrequencyPerMonth() >= 10;
    }
}
