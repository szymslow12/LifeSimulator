package com.codecool.lifeSimulator.model;

public class LifeForm extends Square {

    private Movements movements = new Movements();
  
    public LifeForm(int posX, int poxY) {
        super("LIFE_FORM", 100, posX, poxY);
    }

    public void move(Position position) {
        movements.randomMove(position);
    }

    public void splitIntoToForm() {
        //TODO
    }
}
