package com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy;

import com.DesignPatterns.StrategyPattern.PaymentSystem.PaymentType;

public class UpiStrategy implements PaymentStrategy {
    private final String vpa;

    public UpiStrategy(String vpa) {
        this.vpa = vpa;
    }

    @Override
    public boolean supports(PaymentType paymentType) {
        return paymentType == PaymentType.UPI;
    }

    @Override
    public void payment() {
        System.out.format("Payment done by UPI, your vpa: %s", vpa);
    }
}
