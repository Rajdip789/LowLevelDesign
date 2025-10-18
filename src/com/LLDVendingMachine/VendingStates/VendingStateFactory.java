package com.LLDVendingMachine.VendingStates;

import com.LLDVendingMachine.VendingMachine;
import com.LLDVendingMachine.VendingStates.ConcreteStates.DispenseState;
import com.LLDVendingMachine.VendingStates.ConcreteStates.HasMoneyState;
import com.LLDVendingMachine.VendingStates.ConcreteStates.IdleState;
import com.LLDVendingMachine.VendingStates.ConcreteStates.SelectionState;

public class VendingStateFactory {
    public static State createState(VendingMachine machine, StateName stateName) throws Exception {
        return createState(machine, stateName, -1); // Default codeNumber is -1
    }
    public static State createState(VendingMachine machine, StateName stateName, int codeNumber) throws Exception {
        return switch (stateName) {
            case IDLE -> new IdleState(machine);
            case HAS_MONEY -> new HasMoneyState();
            case SELECTION -> new SelectionState();
            case DISPENSE -> new DispenseState(machine, codeNumber);
            default -> throw new IllegalArgumentException("Invalid state: " + stateName);
        };
    }
}
