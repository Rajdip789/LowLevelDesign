package com.DesignPatterns.CommandPattern.AirConditioner.command;

import com.DesignPatterns.CommandPattern.AirConditioner.receiver.AirConditioner;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ShowStatusCommand implements ICommand {

    private final AirConditioner airConditioner;

    @Override
    public void execute() {
        System.out.println("\n--- AC STATUS ---");
        System.out.println("Power: " + (airConditioner.isOn() ? "ON" : "OFF"));
        System.out.println("Temperature: " + airConditioner.getTemperature() + "°C");
        System.out.println("-----------------");
    }

    @Override
    public void undo() {
        System.out.println("Nothing to undo for ShowStatusCommand.");
    }
}

