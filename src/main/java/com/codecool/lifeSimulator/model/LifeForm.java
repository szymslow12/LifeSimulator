package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public class LifeForm extends Square {

    private Movements movements = new Movements();

    public void move(Position position) {
        movements.randomMove(position);
    }

    public void splitIntoToForm() {
        //TODO
    }

}
