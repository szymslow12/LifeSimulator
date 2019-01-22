package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.Planet;

public class AppController {
    private Planet planet;

    public synchronized Planet getPlanet() {
        return planet;
    }

    public void run() {
        System.out.println(planet);
    }
}
