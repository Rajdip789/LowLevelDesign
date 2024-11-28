package com.LLDATMMachine.ATMStates.ConcreteStates;

import com.LLDATMMachine.ATM;
import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ATMStateFactory;
import com.LLDATMMachine.ATMStates.StateName;
import com.LLDATMMachine.Card;

public class HasCardState extends ATMState {

    public HasCardState() {
        System.out.println("Enter your card pin number: ");
    }

    @Override
    public void authenticatePin(ATM atm, Card card, int pin) {

        if(card.isCorrectPINEntered(pin)) {
            atm.setCurrentATMState(ATMStateFactory.createState(StateName.SELECT_OPERATION));
        } else {
            System.out.println("Invalid PIN number");
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(ATMStateFactory.createState(StateName.IDLE));
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
