package com.codecool.lifeSimulator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class FillingMap {

    private int heightMap;
    private int widthMap;
    private Square[][] planetState;
    private List<Position> usedPosition = new ArrayList<>();

    public FillingMap(int heightMap, int widthMap, Square[][] planetState) {
        this.heightMap = heightMap;
        this.widthMap = widthMap;
        this.planetState = planetState;
    }

    public void fillMap(int percentOfMap, int count) {
        if (checkFillingProportions(percentOfMap, count)) {
            fillMapWithFood(percentOfMap);
            fillMapWithLifeForm(count);
            fillMapWithBlank();
        }
        throw new IllegalArgumentException("Wrong proportions");
    }

    private boolean checkFillingProportions(int percentOfMap, int count) {
        int area = heightMap * widthMap;
        int areaLeft = area - (area * percentOfMap) - count;
        return area > areaLeft;
    }

    public void fillMapWithFood(int percentOfMap) {
        int numberSquareToFill = heightMap * percentOfMap;

        while (numberSquareToFill > 0) {
            Position position = generateUniquePosition();
            usedPosition.add(position);
            int posY = position.getY();
            int posX = position.getX();
            planetState[posY][posX] = new Food(posX, posY);
            numberSquareToFill--;
        }
    }

    public void fillMapWithLifeForm(int count) {
        for (int i = 0; i < count; i++) {
            Position position = generateUniquePosition();
            usedPosition.add(position);
            int posY = position.getY();
            int posX = position.getX();
            planetState[posY][posX] = new LifeForm(posX, posY);
        }
    }

    private void fillMapWithBlank() {

        for (int i = 0; i < heightMap; i++) {
            for (int j = 0; j < widthMap; j++) {
                Position position = new Position(j, i);
                if (!usedPosition.contains(position)) {
                    planetState[i][j] = new Blank(j, i);
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
        int randomY = ThreadLocalRandom.current().nextInt(0, heightMap + 1);
        int randomX = ThreadLocalRandom.current().nextInt(0, widthMap + 1);
        return new Position(randomX, randomY);
    }

    private boolean checkPositionIsNotUsed(Position position) {
        return usedPosition.contains(position);
    }

}
