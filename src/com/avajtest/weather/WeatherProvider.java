package com.avajtest.weather;

import com.avajtest.simulator.vehicles.Coordinates;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {
            "RAIN",
            "FOG",
            "SUN",
            "SNOW"
    };

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider(){
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int v;

        v = coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight();

        return weather[v % 4];


    }
}
