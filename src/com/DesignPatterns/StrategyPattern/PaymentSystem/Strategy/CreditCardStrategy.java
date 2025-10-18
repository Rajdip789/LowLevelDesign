package com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy;

import com.DesignPatterns.StrategyPattern.PaymentSystem.PaymentType;
import lombok.Data;

@Data
public class CreditCardStrategy implements PaymentStrategy {
    private final String name;
    private final String cardNumber;

    public CreditCardStrategy(String name, String cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean supports(PaymentType paymentType) {
        return paymentType == PaymentType.CREDIT_CARD;
    }

    @Override
    public void payment() {
        System.out.format("Payment done by Credit Card: name: %s, Card Number: %s%n", name, cardNumber);
    }
}
