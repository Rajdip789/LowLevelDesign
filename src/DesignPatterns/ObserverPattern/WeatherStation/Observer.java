package DesignPatterns.ObserverPattern.WeatherStation;

public interface Observer {
    public void update(int temperature, int humidity);
}