package com.codecool.lifeSimulator.model;

import java.util.stream.IntStream;

public class Planet {
    private Square[][] planetState;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHight, int planetWidth) {
        planetState = new Square[planetHight][planetWidth];
    }


    public void generatePlanetState() {
        IntStream.range(0, planetState.length).forEach(
            height -> IntStream.range(0, planetState[height].length).forEach(
                width -> planetState[height][width] = new Square()
            )
        );
    }
}
