package com.DesignPatterns.CommandPattern.AirConditioner.command;

import com.DesignPatterns.CommandPattern.AirConditioner.receiver.AirConditioner;
import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
public class TurnACOffCommand implements ICommand {

    AirConditioner airConditioner;

    @Override
    public void execute() {
        airConditioner.turnOffAC();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAC();
    }
}
