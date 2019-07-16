package com.avajtest.simulator.vehicles;

import java.util.*;

import com.avajtest.simulator.Main;
import com.avajtest.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(this.coordinates);

        HashMap<String, String>

        text = new HashMap<String, String>(){{
            put("SUN", "Doubt that the sun doth move");
            put("RAIN", "Much rain wears the marble");
            put("FOG", "Hover through the fog and filthy air");
            put("SNOW", "I wonder if the snow loves the trees and fields that it kisses them so softly?");
        }};

        if (weather.equals("SUN"))
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
        else if (weather.equals("RAIN"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
        else if (weather.equals("FOG"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
        else if (weather.equals("SNOW"))
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);

        Main.writer.println("Baloon#" + this.name + "(" + this.id + "): " + text.get(weather));

        if (this.coordinates.getHeight() == 0){
            Main.writer.println("Baloon#" + this.name + "(" + this.id + "): landing.");
            this.weatherTower.unregister(this);
            Main.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + "unregistered from weather tower.");
        }
    }

    public void registerTower(WeatherTower weatherTower){
        this.weatherTower= weatherTower;
        this.weatherTower.register(this);
        Main.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + "registered to weather tower.");
    }
}
