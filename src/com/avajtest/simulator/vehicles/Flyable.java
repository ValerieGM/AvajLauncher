package com.avajtest.simulator.vehicles;

import com.avajtest.simulator.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);
}