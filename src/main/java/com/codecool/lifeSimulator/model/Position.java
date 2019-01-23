package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.model.squareLogic.Square;

public class Position {

    private int posX;
    private int posY;
    private Square square;

    public Position(int posX, int posY, Square square) {
        this.posX = posX;
        this.posY = posY;
        this.square = square;
    }

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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return String.format("[x=%s, y=%s]", posX, posY);
    }
}
