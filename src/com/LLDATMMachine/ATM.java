package com.LLDATMMachine;

import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ConcreteStates.IdleState;

public class ATM  {

    private static ATM atmObject = new ATM();

    ATMState currentATMState;

    private int atmBalance;
    int noOfFiveHundredNotes;
    int noOfTwoHundredNotes;
    int noOfOneHundredNotes;

    private ATM() { }

    public static ATM getATMObject() {
        atmObject.setCurrentATMState(new IdleState());
        return atmObject;
    }

    public ATMState getCurrentATMState() {
        return currentATMState;
    }

    public void setCurrentATMState(ATMState currentATMState) {
        this.currentATMState = currentATMState;
    }

    public int getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfFiveHundredNotes, int noOfTwoHundredNotes, int noOfOneHundredNotes) {
        this.atmBalance = atmBalance;

        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfTwoHundredNotes = noOfTwoHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfTwoHundredNotes() {
        return noOfTwoHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductATMBalance(int amount) {
        atmBalance = atmBalance - amount;
    }

    public void deductFiveHundredNotes(int number) {
        noOfFiveHundredNotes = noOfFiveHundredNotes - number;
    }

    public void deductTwoHundredNotes(int number) {
        noOfTwoHundredNotes = noOfTwoHundredNotes - number;
    }

    public void deductOneHundredNotes(int number) {
        noOfOneHundredNotes = noOfOneHundredNotes - number;
    }

    public void printCurrentATMStatus() {
        System.out.println("Balance: " + atmBalance);
        System.out.println("500 Notes: " + noOfFiveHundredNotes);
        System.out.println("200 Notes: " + noOfTwoHundredNotes);
        System.out.println("100 Notes: " + noOfOneHundredNotes);
    }
}
