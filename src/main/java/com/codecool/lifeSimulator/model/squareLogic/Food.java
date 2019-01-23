package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.controller.AppController;

public class Food extends Square {

    public Food(int posX, int poxY, AppController appController) {
        super("FOOD", 5, posX, poxY, appController);
    }
}
