package com.DesignPatterns.StatePattern.PhoneState;

public abstract class State {
    protected Phone phone;

    public State(Phone phone) {
        this.phone = phone;
    }

    public abstract String onHome();
    public abstract String onPower();
}
