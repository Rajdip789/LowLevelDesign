package com.LLDATMMachine.ATMStates.ConcreteStates;

import com.LLDATMMachine.ATM;
import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ATMStateFactory;
import com.LLDATMMachine.ATMStates.StateName;
import com.LLDATMMachine.Card;

public class CheckBalanceState extends ATMState {

    public CheckBalanceState() {

    }

    @Override
    public void displayBalance(ATM atm, Card card) {
        System.out.println("Your balance is: " + card.getBankBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(ATMStateFactory.createState(StateName.IDLE));
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
