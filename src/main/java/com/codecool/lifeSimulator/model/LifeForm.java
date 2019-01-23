package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public class LifeForm extends Square implements Runnable{
    private AppController controller;
    private volatile boolean isRunning = true;
    private Movements movements = new Movements();
  
    public LifeForm(int posX, int poxY, AppController controller) {
        super("LIFE_FORM", 100, posX, poxY, controller);
    }

    public void splitIntoToForm() {
        //TODO
    }

    @Override
    public void run() {

        while(isRunning) {
            Position position = getPosition();
            movements.randomMove(position);

            try {
                controller.shufflePlanetState();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
