package com.DesignPatterns.StrategyPattern.PaymentSystem;

import com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy.CreditCardStrategy;
import com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy.DebitCardStrategy;
import com.DesignPatterns.StrategyPattern.PaymentSystem.Strategy.UpiStrategy;

import java.util.Arrays;
import java.util.Scanner;

public class PaymentSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        PaymentContext paymentContext = new PaymentContext(
                Arrays.asList(
                        new CreditCardStrategy("Rajdip Pal", "1234567890123456"),
                        new DebitCardStrategy("Rajdip Pal", "1234567890123456"),
                        new UpiStrategy("rajdip14.pa@okciti")
                )
        );

        System.out.println("Enter your choice payment method: \n 1. Credit Card \n 2. Debit Card \n 3. UPI");
        int paymentMethod = sc.nextInt();

        PaymentType paymentType = paymentMethod == 1 ? PaymentType.CREDIT_CARD :
                paymentMethod == 2 ? PaymentType.DEBIT_CARD :
                        paymentMethod == 3 ? PaymentType.UPI : null;

        if (paymentType == null) {
            System.out.println("Invalid payment method");
            return;
        }

        paymentContext.getStrategy(paymentType).payment();
    }
}
