package com.codecool.lifeSimulator.model;

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


    private Square generateSquare(int posX, int posY) {
        return new Blank(posX, posY);
    }


    public synchronized void generateFoodOnRandomPosition() throws InterruptedException {
        boolean isGenerated;
        Thread.sleep(1000);
    }
}
