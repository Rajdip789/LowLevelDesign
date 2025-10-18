package com.LLDVendingMachine.VendingStates.ConcreteStates;

import com.LLDVendingMachine.Item;
import com.LLDVendingMachine.VendingMachine;
import com.LLDVendingMachine.VendingStates.State;
import com.LLDVendingMachine.VendingStates.StateName;
import com.LLDVendingMachine.VendingStates.VendingStateFactory;

public class DispenseState extends State {

    public DispenseState(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Currently Vending machine is in DispenseState");
        dispenseProduct(machine, codeNumber);
    }

    @Override
    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        System.out.println("Product has been dispensed");
        Item item = machine.getInventory().getItem(codeNumber);
        machine.getInventory().updateSoldOutItem(codeNumber);
        machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.IDLE));
        return item;
    }
}
