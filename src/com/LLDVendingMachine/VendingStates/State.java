package com.LLDVendingMachine.VendingStates;

import com.LLDVendingMachine.Coin;
import com.LLDVendingMachine.Item;
import com.LLDVendingMachine.VendingMachine;

import java.util.List;

public abstract class State {

    public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
        throw new Exception("You can not click on insert coin button in this state");
    }

    public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
        throw new Exception("You can not select product button in this state");
    }

    public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
        throw new Exception("You can not insert coin in this state");
    }

    public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("You can not choose Product in this state");
    }

    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("You can not get change in this state");
    }

    public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
        throw new Exception("Product can not be dispensed in this state");
    }

    public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
        throw new Exception("Money can not be refunded in this state");
    }

    public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
        throw new Exception("inventory can not be updated in Dispense state");
    }

}
