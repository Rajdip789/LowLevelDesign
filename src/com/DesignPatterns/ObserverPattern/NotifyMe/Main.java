package com.DesignPatterns.ObserverPattern.NotifyMe;

import com.DesignPatterns.ObserverPattern.NotifyMe.Observable.IphoneObservableImpl;
import com.DesignPatterns.ObserverPattern.NotifyMe.Observable.StocksObservable;
import com.DesignPatterns.ObserverPattern.NotifyMe.Observer.EmailAlertObserverImpl;
import com.DesignPatterns.ObserverPattern.NotifyMe.Observer.MobileAlertObserverImpl;
import com.DesignPatterns.ObserverPattern.NotifyMe.Observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        StocksObservable stocksObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc@gmail.com", stocksObservable);
        NotificationAlertObserver observer2 = new MobileAlertObserverImpl("rajdip14", stocksObservable);

        stocksObservable.add(observer1);
        stocksObservable.add(observer2);

       stocksObservable.setStockCount(20);
    }
}
