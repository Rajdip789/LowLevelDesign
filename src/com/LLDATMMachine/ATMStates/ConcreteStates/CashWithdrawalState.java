package com.LLDATMMachine.ATMStates.ConcreteStates;

import com.LLDATMMachine.ATM;
import com.LLDATMMachine.ATMStates.ATMState;
import com.LLDATMMachine.ATMStates.ATMStateFactory;
import com.LLDATMMachine.ATMStates.StateName;
import com.LLDATMMachine.AmountWithdrawal.CashWithdrawProcessor;
import com.LLDATMMachine.AmountWithdrawal.FiveHundredWithdrawProcessor;
import com.LLDATMMachine.AmountWithdrawal.OneHundredWithdrawProcessor;
import com.LLDATMMachine.AmountWithdrawal.TwoHundredWithdrawProcessor;
import com.LLDATMMachine.Card;

public class CashWithdrawalState extends ATMState {

    public CashWithdrawalState() {
        System.out.println("Please enter the withdrawal amount: ");
    }

    @Override
    public void cashWithdrawal(ATM atm, Card card, int withdrawalAmount) {

        if(atm.getAtmBalance() < withdrawalAmount) {
            System.out.println("Insufficient fund in the ATM Machine.");
            exit(atm);
        } else if (card.getBankBalance() < withdrawalAmount) {
            System.out.println("Insufficient fund in your bank account.");
            exit(atm);
        } else if (withdrawalAmount%100 != 0) {
            System.out.println("Oops! Amount must be multiple of 100.");
            exit(atm);
        } else {

            card.deductBankBalance(withdrawalAmount);
            atm.deductATMBalance(withdrawalAmount);

            CashWithdrawProcessor cashWithdrawProcessor = new FiveHundredWithdrawProcessor(
                    new TwoHundredWithdrawProcessor(
                            new OneHundredWithdrawProcessor(null)));

            cashWithdrawProcessor.withdraw(atm, withdrawalAmount);
            exit(atm);
        }
    }

    @Override
    public void exit(ATM atm) {
        returnCard();
        atm.setCurrentATMState(ATMStateFactory.createState(StateName.IDLE));
        System.out.println("Exit happens");
    }

    @Override
    public void returnCard() {
        System.out.println("Please collect your card");
    }
}
