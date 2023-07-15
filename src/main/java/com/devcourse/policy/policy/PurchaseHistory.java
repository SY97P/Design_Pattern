package com.devcourse.policy.policy;

public class PurchaseHistory {
    private final long totalAmount;
    private final int purchaseFrequencyPerMonth;
    private final double returnRate;

    public PurchaseHistory(long totalAmount, int purchaseFrequencyPerMonth, double returnRate) {
        this.totalAmount = totalAmount;
        this.purchaseFrequencyPerMonth = purchaseFrequencyPerMonth;
        this.returnRate = returnRate;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public int getPurchaseFrequencyPerMonth() {
        return purchaseFrequencyPerMonth;
    }

    public double getReturnRate() {
        return returnRate;
    }
}
