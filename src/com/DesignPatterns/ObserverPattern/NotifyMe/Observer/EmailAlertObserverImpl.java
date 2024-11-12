package com.DesignPatterns.ObserverPattern.NotifyMe.Observer;

import com.DesignPatterns.ObserverPattern.NotifyMe.Observable.StocksObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StocksObservable observable;


    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable =  observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "Product is in stock hurry up");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("Mail sent to: " + emailId);
    }
}
