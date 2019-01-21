package com.codecool.lifeSimulator.model;

public class Square {

    private String name;
    private int energy;

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
}
