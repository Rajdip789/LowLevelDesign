package DesignPatterns.ObserverPattern.WeatherStation;

public class AverageTemperatureDisplay implements Observer {

    private int sumOfTemperatures;
    private int totalTemperatures;

    public AverageTemperatureDisplay(Observable observable) {
        sumOfTemperatures = 0;
        totalTemperatures = 0;
        observable.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        sumOfTemperatures += temperature;
        totalTemperatures++;
        display();
    }

    public void display() {
        System.out.println("Average Temperature for the past " + totalTemperatures + " records " + sumOfTemperatures/totalTemperatures);
    }

}

