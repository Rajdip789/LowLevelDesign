package com.LLDATMMachine;

public class ATMRoom {

    ATM atm;
    User user;

    public static void main(String[] args) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.printCurrentATMStatus();

        atmRoom.atm.getCurrentATMState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getCurrentATMState().authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 5477);
        atmRoom.atm.getCurrentATMState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWAL);
        atmRoom.atm.getCurrentATMState().cashWithdrawal(atmRoom.atm, atmRoom.user.getCard(), 2300);

        atmRoom.atm.printCurrentATMStatus();
    }

    private void initialize() {

        atm = ATM.getATMObject();
        atm.setAtmBalance(3500, 4, 5, 5);

        this.user = createUser();
    }

    private User createUser() {

        User user = new User();
        user.setCard(createCard());

        return user;
    }

    private Card createCard() {

        Card card = new Card();
        card.setBankAccount(createBankAccount());

        return card;
    }

    private UserBankAccount createBankAccount() {

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);

        return bankAccount;
    }
}
