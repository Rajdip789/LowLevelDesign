package com.DesignPatterns.StrategyPattern.VehicleDriving;

import com.DesignPatterns.StrategyPattern.VehicleDriving.Strategy.DriveStrategy;

public class Vehicle {
    DriveStrategy driveStrategy;

    Vehicle(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }

    public void drive() {
        driveStrategy.drive();
    }
}
