package com.DesignPatterns.StrategyPattern.PaymentSystem;

public interface PaymentStrategy {
    boolean supports(PaymentType paymentType);
    void payment();
}
