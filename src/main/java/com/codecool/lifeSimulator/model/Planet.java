package com.codecool.lifeSimulator.model;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

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
        Random random = new Random();
        boolean isGenerated = false;
        int numberOfFoodToAdd = ThreadLocalRandom.current().nextInt(1, 5);
        System.out.println(Thread.currentThread().getName() + " started generating food!");
        for (int i = 0; i < numberOfFoodToAdd; i++) {
            while (!isGenerated) {
                int randomPosX = random.nextInt(planetState[0].length);
                int randomPosY = random.nextInt(planetState.length);
                Square square = planetState[randomPosY][randomPosX];
                isGenerated = generateFood(square);
            }
            isGenerated = false;
        }
    }


    private boolean generateFood(Square square) {
        Position position = square.getPosition();
        int x = position.getX();
        int y = position.getY();
        if (square.getName().equals("BLANK")) {
            System.out.println(String.format("Food generated on positions x=%s, y=%s", x, y));
            planetState[y][x] = new Food(x, y);
            return true;
        }
        return false;
    }
}
