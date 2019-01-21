package com.codecool.lifeSimulator.model;

public class Planet {
    private Square[][] planetState;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHight, int planetWidth) {
        planetState = new Square[planetHight][planetWidth];
    }
}
