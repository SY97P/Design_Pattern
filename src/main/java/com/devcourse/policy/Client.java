package com.devcourse.policy;

import com.devcourse.policy.policy.*;
import com.devcourse.policy.policy.rule.GoldCustomerPurchaseAmountRule;
import com.devcourse.policy.policy.rule.PurchaseFrequencyRule;
import com.devcourse.policy.policy.rule.ReturnRateRule;

public class Client {

    public static void main(String[] args) {
        ExcellentCustomerPolicy goldCustomerPolicy = new ExcellentCustomerPolicy();

        goldCustomerPolicy.add(new GoldCustomerPurchaseAmountRule());
        goldCustomerPolicy.add(new PurchaseFrequencyRule());
        goldCustomerPolicy.add(new ReturnRateRule());

        boolean result = goldCustomerPolicy.complyWithAll(
                new PurchaseHistory(10023324, 20, 0.0001)
        );

        System.out.println(result);
    }

}
