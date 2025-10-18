package com.LLDVendingMachine.VendingStates.ConcreteStates;

import com.LLDVendingMachine.Coin;
import com.LLDVendingMachine.Item;
import com.LLDVendingMachine.VendingMachine;
import com.LLDVendingMachine.VendingStates.State;
import com.LLDVendingMachine.VendingStates.StateName;
import com.LLDVendingMachine.VendingStates.VendingStateFactory;

import java.util.List;

public class SelectionState extends State {

    public SelectionState(){
        System.out.println("Currently Vending machine is in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {

        // 1. Get item from the codeNumber
        Item item = machine.getInventory().getItem(codeNumber);

        // 2. Calculate total amount given by User
        int paidByUser = 0;
        for(Coin coin : machine.getCoinList()) {
            paidByUser = paidByUser + coin.value;
        }

        // 3. Compare product price and amount given by user
        if(paidByUser < item.getPrice()) {
            System.out.println("Insufficient Amount, Price of the product you selected is: " + item.getPrice() + " and you paid: " + paidByUser);
            refundFullMoney(machine);
            throw new Exception("insufficient amount");
        }
        else if(paidByUser >= item.getPrice()) {

            if(paidByUser > item.getPrice()) {
                getChange(paidByUser-item.getPrice());
            }
            machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.DISPENSE, codeNumber));
        }
    }

    @Override
    public int getChange(int returnExtraMoney) throws Exception {
        // Logic for returning the COINs in the dispense tray
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnExtraMoney);
        return returnExtraMoney;

    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.IDLE));
        return machine.getCoinList();
    }
}
