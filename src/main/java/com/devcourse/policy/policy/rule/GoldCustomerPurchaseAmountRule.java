package com.devcourse.policy.policy.rule;

import com.devcourse.policy.policy.PurchaseHistory;

public class GoldCustomerPurchaseAmountRule implements ExcellentCustomerRule {
    @Override
    public boolean ok(PurchaseHistory history) {
        return history.getTotalAmount() >= 1000000;
    }
}
