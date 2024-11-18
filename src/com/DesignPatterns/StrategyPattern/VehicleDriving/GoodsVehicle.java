package com.DesignPatterns.StrategyPattern.VehicleDriving;

import com.DesignPatterns.StrategyPattern.VehicleDriving.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle {

    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}
