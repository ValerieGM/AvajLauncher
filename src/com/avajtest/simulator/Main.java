package com.avajtest.simulator;

import java.io.*;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

import com.avajtest.simulator.vehicles.Flyable;
import com.avajtest.simulator.vehicles.AircraftFactory;

public class Main {

    public static PrintWriter writer;
    /*  private static WeatherTower weatherTower; */
     private static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] arg){
        WeatherTower weatherTower = new WeatherTower();

        try(BufferedReader reader = new BufferedReader(new FileReader(arg[0]))){


            File simulationFile = new File("simulation.txt");
            writer = new PrintWriter(simulationFile);

            String line = reader.readLine();

            if (line != null){

                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 1){
                    System.out.println("Invalid Simulations Count");
                    System.exit(1);
                }
                String arr[];
                while ((line = reader.readLine()) != null) {
                    arr = line.split(" ");
                    Flyable flyable = AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
                    flyable.registerTower(weatherTower);
//                    flyables.add(flyable);
                }
                int v;

                v = 1;
                while (v <= simulations) {

                    weatherTower.changeWeather();
                    v++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            System.out.println("Error Reading File");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Specify Simulator File");
        }finally {
            writer.flush();
            writer.close();
        }

    }

}
