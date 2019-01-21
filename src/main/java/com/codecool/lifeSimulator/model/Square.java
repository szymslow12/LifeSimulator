package com.codecool.lifeSimulator.model;

public class Square {

    private String name;
    private int energy;
    private Position position;

    public Square() {
        this.name = "BLANK";
        this.energy = 0;
    }


    public Square(String name, int energy) {
        this.name = name;
        this.energy = energy;
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
        return String.format("Square: name=%s, energy=%s", name, energy);
    }
}
