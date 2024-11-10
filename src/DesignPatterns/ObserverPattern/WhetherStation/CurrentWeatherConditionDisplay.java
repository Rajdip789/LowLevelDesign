package DesignPatterns.ObserverPattern.WhetherStation;

public class CurrentWeatherConditionDisplay implements Observer {

    private int temperature;
    private int humidity;

    /***
     * In future if we may want to un-register ourselves as an observer
     * it would be handy to already have a reference to the observable.
     ***/
    @SuppressWarnings("unused")
    private Observable observable;

    public CurrentWeatherConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.registerObserver(this);
    }

    @Override
    public void update(int temperature, int humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    private void display() {
        System.out.println("Current Weather condition : Temperature : " + temperature + ", Humidity : " + humidity);
    }
}