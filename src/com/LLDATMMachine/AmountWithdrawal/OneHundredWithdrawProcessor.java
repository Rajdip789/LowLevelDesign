package com.LLDATMMachine.AmountWithdrawal;

import com.LLDATMMachine.ATM;

public class OneHundredWithdrawProcessor extends CashWithdrawProcessor{

    public OneHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int required = remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoOfOneHundredNotes()) {
            atm.deductOneHundredNotes(required);
        } else {
            int oneHundredNotes = atm.getNoOfOneHundredNotes();
            atm.deductFiveHundredNotes(oneHundredNotes);
            balance += (required - oneHundredNotes) * 100;
        }

        if(balance != 0) {
            System.out.println("Oops! Something went wrong.");
        }
    }
}
