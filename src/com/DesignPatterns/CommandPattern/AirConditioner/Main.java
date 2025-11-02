package com.DesignPatterns.CommandPattern.AirConditioner;

import com.DesignPatterns.CommandPattern.AirConditioner.command.SetTemperatureCommand;
import com.DesignPatterns.CommandPattern.AirConditioner.command.ShowStatusCommand;
import com.DesignPatterns.CommandPattern.AirConditioner.command.TurnACOffCommand;
import com.DesignPatterns.CommandPattern.AirConditioner.command.TurnACOnCommand;
import com.DesignPatterns.CommandPattern.AirConditioner.invoker.ACRemoteControl;
import com.DesignPatterns.CommandPattern.AirConditioner.receiver.AirConditioner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AirConditioner ac = new AirConditioner();
        ACRemoteControl remote = new ACRemoteControl();
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Welcome to Smart AC Remote ===");

        boolean exit = false;
        while (!exit) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Turn ON AC");
            System.out.println("2. Turn OFF AC");
            System.out.println("3. Set Temperature");
            System.out.println("4. Undo Last Action");
            System.out.println("5. Redo Last Action");
            System.out.println("6. Show current status");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    remote.setCommand(new TurnACOnCommand(ac));
                    remote.pressButton();
                    break;
                case 2:
                    remote.setCommand(new TurnACOffCommand(ac));
                    remote.pressButton();
                    break;
                case 3:
                    System.out.print("Enter desired temperature: ");
                    int temp = scanner.nextInt();
                    remote.setCommand(new SetTemperatureCommand(ac, temp));
                    remote.pressButton();
                    break;
                case 4:
                    remote.undo();
                    break;
                case 5:
                    remote.redo();
                    break;
                case 6:
                    remote.setCommand(new ShowStatusCommand(ac));
                    remote.pressButton();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Exiting Smart AC Remote. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

        scanner.close();
    }
}
