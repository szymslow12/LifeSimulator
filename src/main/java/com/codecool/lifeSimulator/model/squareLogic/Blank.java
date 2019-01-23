package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.controller.AppController;

public class Blank extends Square {

    public Blank(int posX, int poxY, AppController appController) {
        super("BLANK", 0, posX, poxY, appController);
    }
}
