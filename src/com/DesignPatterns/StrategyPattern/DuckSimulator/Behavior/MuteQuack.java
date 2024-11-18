package com.DesignPatterns.StrategyPattern.DuckSimulator.Behavior;

public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< silence >>");
    }
}
