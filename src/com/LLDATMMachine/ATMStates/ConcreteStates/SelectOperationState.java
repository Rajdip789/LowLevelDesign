package com.LLDATMMachine.ATMStates.ConcreteStates;

import com.LLDATMMachine.ATM;
import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ATMStateFactory;
import com.LLDATMMachine.ATMStates.StateName;
import com.LLDATMMachine.Card;
import com.LLDATMMachine.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState() {
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType txnType) {
        switch (txnType) {
            case CASH_WITHDRAWAL:
                atm.setCurrentATMState(ATMStateFactory.createState(StateName.CASH_WITHDRAWAL));
                break;

            case BALANCE_CHECK:
                atm.setCurrentATMState(ATMStateFactory.createState(StateName.CHECK_BALANCE));
                break;

            default:
                System.out.println("Invalid option");
                exit(atm);
        }
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setCurrentATMState(ATMStateFactory.createState(StateName.IDLE));
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard(){
        System.out.println("Please collect your card");
    }

    private void showOperations(){
        System.out.println("Please select the Operation");
        TransactionType.showAllTransactionTypes();
    }
}
