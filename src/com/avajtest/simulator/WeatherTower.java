package com.avajtest.simulator;

import com.avajtest.simulator.vehicles.Coordinates;
import com.avajtest.weather.WeatherProvider;

public class WeatherTower extends Tower{
    public String getWeather(Coordinates coordinates){
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void    changeWeather(){
        this.conditionsChanged();
    }
}
