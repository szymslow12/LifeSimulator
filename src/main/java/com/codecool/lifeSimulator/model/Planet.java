package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.view.PlanetRender;

import java.util.Random;

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


    public void generateFoodOnRandomPosition() {
        boolean isGenerated= false;
        System.out.println(Thread.currentThread().getName() + " started generating food!");
        while (!isGenerated) {
            Random random = new Random();
            int randomPosX = random.nextInt(planetState[0].length);
            int randomPosY = random.nextInt(planetState.length);
            Square square = planetState[randomPosY][randomPosX];
            if (square.getName().equals("BLANK")) {
                System.out.println(String.format("Food generated on positions x=%s, y=%s", randomPosX, randomPosY));
                planetState[randomPosY][randomPosX] = new Food(randomPosX, randomPosY);
                isGenerated = true;
            }
        }
    }
}
