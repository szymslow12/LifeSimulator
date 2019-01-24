package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.model.squareLogic.Square;

public class Planet {
    private Square[][] planetState;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHeight, int planetWidth) {
        planetState = new Square[planetHeight][planetWidth];
        generatePlanetState();

    }

    private void generatePlanetState() {
        FillingMap fillingMap = new FillingMap(planetState);
        fillingMap.fillMap(30, 10);
    }

}
