package com.LLDVendingMachine.VendingStates.ConcreteStates;

import com.LLDVendingMachine.Item;
import com.LLDVendingMachine.VendingMachine;
import com.LLDVendingMachine.VendingStates.State;
import com.LLDVendingMachine.VendingStates.StateName;
import com.LLDVendingMachine.VendingStates.VendingStateFactory;

import java.util.ArrayList;

public class IdleState extends State {

    public IdleState() {
        System.out.println("Currently Vending machine is in IdleState");
    }

    public IdleState(VendingMachine machine) {
        System.out.println("Currently Vending machine is in IdleState");
        machine.setCoinList(new ArrayList<>());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.HAS_MONEY));
    }

    @Override
    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        machine.getInventory().addItem(item, codeNumber);
    }
}
