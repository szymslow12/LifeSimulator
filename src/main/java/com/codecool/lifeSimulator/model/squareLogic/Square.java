package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.Position;

public class Square {

    private String name;
    private int energy;
    private Position position;
    private AppController appController;

    public Square(String name, int energy, int posX, int posY, AppController appController) {
        this.name = name;
        this.energy = energy;
        position = new Position(posX, posY);
        this.appController = appController;
    }

    public AppController getAppController() {
        return appController;
    }

    public String getName() {
        return name;
    }


    public int getEnergy() {
        return energy;
    }


    public void setEnergy(int energy) {
        this.energy = energy;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }


    public boolean isPositionEqual(Square square) {
        Position toCompare = square.position;
        return position.getX() == toCompare.getX() &&
                position.getY() == toCompare.getY();
    }


    @Override
    public String toString() {
        return String.format("Square: name=%s, energy=%s, position=%s", name, energy, position);
    }
}
