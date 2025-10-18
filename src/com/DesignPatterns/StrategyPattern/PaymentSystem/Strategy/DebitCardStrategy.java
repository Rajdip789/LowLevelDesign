package com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy;

import com.DesignPatterns.StrategyPattern.PaymentSystem.PaymentType;
import lombok.Data;

@Data
public class DebitCardStrategy implements PaymentStrategy {
    private final String name;
    private final String cardNumber;

    public DebitCardStrategy(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean supports(PaymentType paymentType) {
        return paymentType == PaymentType.DEBIT_CARD;
    }

    @Override
    public void payment() {
        System.out.format("Payment done by Debit Card: name: %s, Card Number: %s%n", name, cardNumber);
    }
}
