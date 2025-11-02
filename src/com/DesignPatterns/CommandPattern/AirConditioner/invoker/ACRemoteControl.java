package com.DesignPatterns.CommandPattern.AirConditioner.invoker;

import com.DesignPatterns.CommandPattern.AirConditioner.command.ICommand;
import lombok.Setter;

import java.util.Stack;

public class ACRemoteControl {

    @Setter
    ICommand command;
    ICommand lastCommand;
    Stack<ICommand> acCommandHistory = new Stack<>();

    public void pressButton() {
        command.execute();
        acCommandHistory.push(command);
    }

    public void undo() {
        if(!acCommandHistory.empty()) {
            lastCommand = acCommandHistory.pop();
            lastCommand.undo();

            System.out.println("Undo last command successfully.");
        }
        System.out.println("Nothing to undo");
    }

    public void redo() {
        if(lastCommand != null) {
            lastCommand.execute();
            acCommandHistory.push(lastCommand);
            lastCommand = null;

            System.out.println("Redo successfully");
        }
        System.out.println("Nothing to redo");
    }
}
