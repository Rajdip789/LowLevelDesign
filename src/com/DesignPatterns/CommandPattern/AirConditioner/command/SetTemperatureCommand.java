package com.DesignPatterns.CommandPattern.AirConditioner.command;

import com.DesignPatterns.CommandPattern.AirConditioner.receiver.AirConditioner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SetTemperatureCommand implements ICommand{

    AirConditioner airConditioner;
    int lastTemperature;
    int temperature;

    public SetTemperatureCommand(AirConditioner airConditioner, int temperature) {
        this.airConditioner = airConditioner;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        lastTemperature = airConditioner.getTemperature();
        airConditioner.setTemperature(temperature);
    }

    @Override
    public void undo() {
        airConditioner.setTemperature(lastTemperature);
    }
}
