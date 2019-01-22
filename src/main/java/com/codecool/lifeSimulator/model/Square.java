package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.Canvas;

public class Square {

    private String name;
    private int energy;
    private Position position;

    public Square(String name, int energy, int posX, int posY) {
        this.name = name;
        this.energy = energy;
        position = new Position(posX, posY);
    }

    public String getName() {
        return name;
    }


    public int getEnergy() {
        return energy;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }


    @Override
    public String toString() {
        return String.format("Square: name=%s, energy=%s, position=%s", name, energy, position);
    }
}
