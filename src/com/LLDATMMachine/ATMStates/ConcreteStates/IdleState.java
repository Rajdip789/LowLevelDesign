package com.LLDATMMachine.ATMStates.ConcreteStates;

import com.LLDATMMachine.ATM;
import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ATMStateFactory;
import com.LLDATMMachine.ATMStates.StateName;
import com.LLDATMMachine.Card;

public class IdleState extends ATMState {

    @Override
    public void insertCard(ATM atm, Card card) {
        System.out.println("Card is inserted");
        atm.setCurrentATMState(ATMStateFactory.createState(StateName.HAS_CARD));
    }
}
