package com.avajtest.simulator.vehicles;

import java.util.*;

import com.avajtest.simulator.Main;
import com.avajtest.simulator.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        HashMap<String, String>

                text = new HashMap<String, String>(){{
            put("SUN", "Doubt that the sun doth move");
            put("RAIN", "Much rain wears the marble");
            put("FOG", "Hover through the fog and filthy air");
            put("SNOW", "I wonder if the snow loves the trees and fields that it kisses them so gently?");
        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);

        Main.writer.println("Helicopter#" + this.name + "(" + this.id + "): " + text.get(weather));

        if (this.coordinates.getHeight() == 0){
            Main.writer.println("Helicopter#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Main.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + "unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower= weatherTower;
        this.weatherTower.register(this);
        Main.writer.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + "registered to weather tower.");
    }
}
