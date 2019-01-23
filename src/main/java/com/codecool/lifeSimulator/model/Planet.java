package com.codecool.lifeSimulator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Planet {
    private Square[][] planetState;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHeight, int planetWidth) {
        planetState = new Square[planetHeight][planetWidth];
    }


    public void generatePlanetState() {
        IntStream.range(0, planetState.length).forEach(
            height -> IntStream.range(0, planetState[height].length).forEach(
                width -> planetState[height][width] = generateSquare(width, height)
            )
        );
    }


    private Square generateSquare(int posX, int posY) {
        return new Blank(posX, posY);
    }


    public List<LifeForm> getLifeForms() {
        List<LifeForm> lifeForms = new ArrayList<>();
        Stream.of(planetState).forEach(
            squareLine -> Stream.of(squareLine).forEach(
                square -> addToList(square, lifeForms)
            )
        );
        return lifeForms;
    }


    private void addToList(Square square, List<LifeForm> lifeForms) {
        if (square.getName().equals("LIFE_FORM")) {
            lifeForms.add((LifeForm) square);
        }
    }
}
