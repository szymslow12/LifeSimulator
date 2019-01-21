package com.codecool.lifeSimulator.model;

public class Position {

    private int posX;
    private int posY;

    public Position(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }


    public int getX() {
        return posX;
    }


    public int getY() {
        return posY;
    }
}
