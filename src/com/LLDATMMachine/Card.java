package com.LLDATMMachine;

public class Card {

    static int PIN_NUMBER = 5477;

    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String cardHolderName;
    private UserBankAccount bankAccount;

    public boolean isCorrectPINEntered(int pin) {
        return pin == PIN_NUMBER;
    }

    public int getBankBalance() {
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int amount){
        bankAccount.withdrawalBalance(amount);
    }

    public void setBankAccount(UserBankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }
}
