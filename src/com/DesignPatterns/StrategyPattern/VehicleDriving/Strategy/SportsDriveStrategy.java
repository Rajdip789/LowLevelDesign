package com.DesignPatterns.StrategyPattern.VehicleDriving.Strategy;

public class SportsDriveStrategy implements  DriveStrategy {

    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}
