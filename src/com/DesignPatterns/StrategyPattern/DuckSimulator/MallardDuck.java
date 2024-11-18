package com.DesignPatterns.StrategyPattern.DuckSimulator;

import com.DesignPatterns.StrategyPattern.DuckSimulator.Behavior.FlyWithWings;
import com.DesignPatterns.StrategyPattern.DuckSimulator.Behavior.Quack;

public class MallardDuck extends Duck{

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    @Override
    public void display() {
        System.out.println("I'm a real Mallard duck");
    }
}
