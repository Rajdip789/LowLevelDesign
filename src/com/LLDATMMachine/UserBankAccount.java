package com.LLDATMMachine;

public class UserBankAccount {

    int balance;

    int getBalance() {
        return balance;
    }

    void setBalance(int balance) {
        this.balance = balance;
    }

    public void withdrawalBalance(int amount) {
        balance = balance - amount;
    }
}
