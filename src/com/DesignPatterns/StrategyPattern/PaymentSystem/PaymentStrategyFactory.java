package com.DesignPatterns.StrategyPattern.PaymentSystem;

import com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy.PaymentStrategy;

import java.util.List;

public class PaymentStrategyFactory {
    List<PaymentStrategy> strategies;

    public PaymentStrategyFactory(List<PaymentStrategy> strategies) {
        this.strategies = strategies;
    }

    public PaymentStrategy getStrategy(PaymentType paymentType) {
        return strategies.stream().
                filter(strategy -> strategy.supports(paymentType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Payment Type not supported"));
    }
}
