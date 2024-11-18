package com.DesignPatterns.StrategyPattern.DuckSimulator.Behavior;

public class Squeak implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
