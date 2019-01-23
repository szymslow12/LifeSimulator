package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.squareLogic.Square;

public class Planet {
    private Square[][] planetState;
    private AppController appController;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHeight, int planetWidth, AppController appController) {
        planetState = new Square[planetHeight][planetWidth];
        this.appController = appController;
        generatePlanetState();

    }

    private void generatePlanetState() {
        FillingMap fillingMap = new FillingMap(planetState,appController);
        fillingMap.fillMap(30, 10);
    }

}
