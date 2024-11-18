package com.DesignPatterns.StrategyPattern.VehicleDriving;

import com.DesignPatterns.StrategyPattern.VehicleDriving.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle {

    SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
