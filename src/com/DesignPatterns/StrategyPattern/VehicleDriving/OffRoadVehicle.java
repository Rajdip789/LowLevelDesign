package com.DesignPatterns.StrategyPattern.VehicleDriving;

import com.DesignPatterns.StrategyPattern.VehicleDriving.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle {

    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}
