package com.LLDVendingMachine.VendingStates.ConcreteStates;

import com.LLDVendingMachine.Coin;
import com.LLDVendingMachine.VendingMachine;
import com.LLDVendingMachine.VendingStates.State;
import com.LLDVendingMachine.VendingStates.StateName;
import com.LLDVendingMachine.VendingStates.VendingStateFactory;

import java.util.List;

public class HasMoneyState extends State {

    public HasMoneyState(){
        System.out.println("Currently Vending machine is in HasMoneyState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.SELECTION));
    }

    @Override
    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        System.out.println("Accepted the coin");
        machine.getCoinList().add(coin);
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        machine.setVendingMachineState(VendingStateFactory.createState(machine, StateName.IDLE));
        return machine.getCoinList();
    }
}
