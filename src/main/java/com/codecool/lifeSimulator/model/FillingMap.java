package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.squareLogic.Blank;
import com.codecool.lifeSimulator.model.squareLogic.Food;
import com.codecool.lifeSimulator.model.squareLogic.LifeForm;
import com.codecool.lifeSimulator.model.squareLogic.Square;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FillingMap {

    private int heightMap;
    private int widthMap;
    private Square[][] planetState;
    private List<Position> usedPosition = new ArrayList<>();
    private AppController appController;

    public FillingMap(Square[][] planetState, AppController appController) {
        this.heightMap = planetState.length;
        this.widthMap = planetState[0].length;
        this.planetState = planetState;
        this.appController = appController;
    }

    public void fillMap(int percentOfMap, int count) {
        if (checkFillingProportions(percentOfMap, count)) {
            fillMapWithFood(percentOfMap);
            fillMapWithLifeForm(count);
            fillMapWithBlank();
        } else
            throw new IllegalArgumentException("Wrong proportions");
    }

    private boolean checkFillingProportions(int percentOfMap, int count) {
        int area = heightMap * widthMap;
        int areaLeft = area - (area * percentOfMap) - count;
        return area > areaLeft;
    }

    private void fillMapWithFood(int percentOfMap) {
        int numberSquareToFill = heightMap * percentOfMap;

        while (numberSquareToFill > 0) {
            Position position = generateUniquePosition();
            usedPosition.add(position);
            int posY = position.getY();
            int posX = position.getX();
            planetState[posY][posX] = new Food(posX, posY, appController);
            numberSquareToFill--;
        }
    }

    private void fillMapWithLifeForm(int count) {
        for (int i = 0; i < count; i++) {
            Position position = generateUniquePosition();
            usedPosition.add(position);
            int posY = position.getY();
            int posX = position.getX();
            LifeForm lifeForm = new LifeForm(posX, posY, appController);
            planetState[posY][posX] = lifeForm;
            (new Thread(lifeForm)).start();
        }
    }

    private void fillMapWithBlank() {

        for (int i = 0; i < heightMap; i++) {
            for (int j = 0; j < widthMap; j++) {
                if (planetState[i][j] == null) {
                    planetState[i][j] = new Blank(j, i, appController);
                }
            }
        }

    }

    private Position generateUniquePosition() {
        Position position;
        do {
            position = generateRandomPos();
        } while (checkPositionIsNotUsed(position));

        return position;
    }

    private Position generateRandomPos() {
        int randomY = ThreadLocalRandom.current().nextInt(0, heightMap);
        int randomX = ThreadLocalRandom.current().nextInt(0, widthMap);
        return new Position(randomX, randomY);
    }

    private boolean checkPositionIsNotUsed(Position position) {
        return usedPosition.contains(position);
    }

}
