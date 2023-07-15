package com.devcourse.policy.policy;

import com.devcourse.policy.policy.rule.ExcellentCustomerRule;

import java.util.HashSet;
import java.util.Set;

public class ExcellentCustomerPolicy {
    private final Set<ExcellentCustomerRule> ruleSet;

    public ExcellentCustomerPolicy() {
        this.ruleSet = new HashSet<>();
    }

    public void add(final ExcellentCustomerRule rule) {
        ruleSet.add(rule);
    }

    public boolean complyWithAll(final PurchaseHistory history) {
        for (ExcellentCustomerRule eachRule: ruleSet) {
            if (!eachRule.ok(history)) {
                return false;
            }
        }
        return true;
    }
}
