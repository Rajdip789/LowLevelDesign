package com.LLDATMMachine.AmountWithdrawal;

import com.LLDATMMachine.ATM;

public class TwoHundredWithdrawProcessor extends CashWithdrawProcessor{

    public TwoHundredWithdrawProcessor(CashWithdrawProcessor nextCashWithdrawProcessor) {
        super(nextCashWithdrawProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int required = remainingAmount/200;
        int balance = remainingAmount%200;

        if(required <= atm.getNoOfTwoHundredNotes()) {
            atm.deductTwoHundredNotes(required);
        } else {
            int twoHundredNotes = atm.getNoOfTwoHundredNotes();
            atm.deductFiveHundredNotes(twoHundredNotes);
            balance += (required - twoHundredNotes) * 200;
        }

        if(balance != 0) {
            super.withdraw(atm, balance);
        }
    }
}
