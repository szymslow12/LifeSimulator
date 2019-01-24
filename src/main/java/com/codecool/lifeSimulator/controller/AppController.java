package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.FoodGenerator;
import com.codecool.lifeSimulator.model.Planet;
import com.codecool.lifeSimulator.view.PlanetRender;
import com.codecool.lifeSimulator.view.PlanetView;

public class AppController {
    private Planet planet;
    private PlanetView planetView;

    public AppController() {
        planet = new Planet(51, 92);
        planetView = new PlanetView(planet);
        runThreads();
    }

    private void runThreads() {
        (new Thread(new PlanetRender(planetView))).start();
        (new Thread(new FoodGenerator(planet))).start();
    }


    public synchronized Planet getPlanet() {
        return planet;
    }


    public PlanetView getPlanetView() {
        return planetView;
    }

}
