package com.avajtest.simulator;

import java.util.*;

import com.avajtest.simulator.vehicles.Flyable;

public abstract class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable flyable) {
        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditionsChanged() {
        int v;

        v = 0;
        while (v < observers.size()) {
            observers.get(v).updateConditions();
            v++;
        }
    }
}
