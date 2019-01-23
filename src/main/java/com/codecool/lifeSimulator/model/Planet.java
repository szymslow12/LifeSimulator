package com.codecool.lifeSimulator.model;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class Planet {
    private Square[][] planetState;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHeight, int planetWidth) {
        planetState = new Square[planetHeight][planetWidth];
    }


    public void generatePlanetState() {
        FillingMap fillingMap = new FillingMap(planetState);
        fillingMap.fillMap(30,10);
    }


//    public void generatePlanetState() {
//        IntStream.range(0, planetState.length).forEach(
//            height -> IntStream.range(0, planetState[height].length).forEach(
//                width -> planetState[height][width] = generateSquare(width, height)
//            )
//        );
//    }
//
//
//    private Square generateSquare(int posX, int posY) {
//        return new Blank(posX, posY);
//    }


}
