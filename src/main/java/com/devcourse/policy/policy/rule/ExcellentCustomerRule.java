package com.devcourse.policy.policy.rule;

import com.devcourse.policy.policy.PurchaseHistory;

public interface ExcellentCustomerRule {
    boolean ok(final PurchaseHistory history);
}
