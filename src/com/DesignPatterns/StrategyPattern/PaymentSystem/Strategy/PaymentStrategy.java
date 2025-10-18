package com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy;

import com.DesignPatterns.StrategyPattern.PaymentSystem.PaymentType;

public interface PaymentStrategy {
    boolean supports(PaymentType paymentType);
    void payment();
}
