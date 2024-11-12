package com.DesignPatterns.StatePattern.PhoneState;

public class ReadyState extends State {
    public ReadyState(Phone phone) {
        super(phone);
    }

    @Override
    public String onHome() {
        return phone.home();
    }

    @Override
    public String onPower() {
        phone.setState(new OffState(phone));
        return phone.lock();
    }
}
