package com.LLDATMMachine.AmountWithdrawal;

import com.LLDATMMachine.ATM;

public class FiveHundredWithdrawProcessor extends CashWithdrawProcessor {

    public FiveHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int required = remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoOfFiveHundredNotes()) {
            atm.deductFiveHundredNotes(required);
        } else {
            int fiveHundredNotes = atm.getNoOfFiveHundredNotes();
            atm.deductFiveHundredNotes(fiveHundredNotes);
            balance += (required - fiveHundredNotes) * 500;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
