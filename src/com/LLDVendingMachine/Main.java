package com.LLDVendingMachine;

import com.LLDVendingMachine.VendingStates.State;

public class Main {
    public static void main(String[] args) {

        // Initialize the vending machine
        VendingMachine vendingMachine = new VendingMachine();

        try {
            System.out.println("|");
            System.out.println("Filling up the inventory");
            System.out.println("|");

            // Fill and display the inventory of machine
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("Clicking on InsertCoinButton");
            System.out.println("|");

            // Get the current state of the machine
            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            // Get the machine state after clicking insert coin button
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

            System.out.println("|");
            System.out.println("Clicking on ProductSelectionButton");
            System.out.println("|");

            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            // Get the machine state after clicking product selection button
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

        } catch (Exception e) {
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i < 3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            } else if(i < 5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            } else if(i < 7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            } else if(i < 10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine) {

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for (ItemShelf slot : slots) {
            System.out.println("CodeNumber: " + slot.getCode() +
                    " Item: " + slot.getItem().getType().name() +
                    " Price: " + slot.getItem().getPrice() +
                    " isAvailable: " + !slot.isSoldOut());

        }
    }
}
