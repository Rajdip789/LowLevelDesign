package com.LLDATMMachine.ATMStates;

import com.LLDATMMachine.ATMStates.ConcreteStates.*;

public class ATMStateFactory {

    public static ATMState createState(StateName stateName) {
        return switch (stateName) {
            case IDLE -> new IdleState();
            case HAS_CARD -> new HasCardState();
            case SELECT_OPERATION -> new SelectOperationState();
            case CHECK_BALANCE -> new CheckBalanceState();
            case CASH_WITHDRAWAL -> new CashWithdrawalState();
            default -> throw new IllegalArgumentException("Invalid state: " + stateName);
        };
    }
}
