package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.model.squareLogic.Food;
import com.codecool.lifeSimulator.model.squareLogic.Square;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class FoodGenerator implements Runnable {
    private Planet planet;

    public FoodGenerator(Planet planet) {
        this.planet = planet;
    }


    private void generateFoodOnRandomPosition() {
        Square[][] planetState = planet.getPlanetState();
        Random random = new Random();
        boolean isGenerated = false;
        int numberOfFoodToAdd = ThreadLocalRandom.current().nextInt(1, 5);
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
        Square[][] planetState = planet.getPlanetState();
        Position position = square.getPosition();
        int x = position.getX();
        int y = position.getY();
        if (square.getName().equals("BLANK")) {
            planetState[y][x] = new Food(x, y);
            return true;
        }
        return false;
    }

    @Override
    public synchronized void run() {
        while (true) {
            generateFoodOnRandomPosition();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
