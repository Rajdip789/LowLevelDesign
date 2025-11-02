package com.DesignPatterns.CommandPattern.AirConditioner.receiver;

import lombok.Getter;

@Getter
public class AirConditioner {

    boolean isOn;
    int temperature;

    public void turnOnAC(){
        if (!isOn) {
            isOn = true;
            System.out.println("Air Conditioner turned ON.");
        } else {
            System.out.println("AC is already ON.");
        }
    }

    public void turnOffAC() {
        if (isOn) {
            isOn = false;
            System.out.println("Air Conditioner turned OFF.");
        } else {
            System.out.println("AC is already OFF.");
        }
    }

    public void setTemperature(int newTemp) {
        if (!isOn) {
            System.out.println("Cannot set temperature. AC is OFF.");
            return;
        }
        temperature = newTemp;
        System.out.println("Temperature set to " + temperature + "°C.");
    }
}
