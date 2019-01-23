package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.model.Position;
import com.codecool.lifeSimulator.model.moves.Movements;

public class LifeForm extends Square implements Runnable {
    private volatile boolean isRunning = true;
    private Movements movements = new Movements();

    public LifeForm(int posX, int poxY) {
        super("LIFE_FORM", 100, posX, poxY);
    }

    public void splitIntoToForm() {
        //TODO
    }

    @Override
    public synchronized void run() {

        while (isRunning) {
            Position position = getPosition();
            movements.randomMove(position);
            try {
                Thread.sleep(1000);
//                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
