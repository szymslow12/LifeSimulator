package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.model.Position;
import com.codecool.lifeSimulator.model.moves.Movements;

import java.util.concurrent.ThreadLocalRandom;

public class LifeForm extends Square implements Runnable {
    private volatile boolean isRunning = true;
    private Movements movements = new Movements();

    public LifeForm(int posX, int poxY) {
        super("LIFE_FORM", 60, posX, poxY);
    }

    private void splitIntoTwoForm() {
        int x = getPosition().getX();
        int y = getPosition().getY();
        (new Thread(new LifeForm(x, y))).start();
    }

    @Override
    public synchronized void run() {

        while (isRunning) {
            if (isFullOfEnergy()) {
                splitIntoTwoForm();
            }
            decreaseEnergy();
            if (isMoving()) {
                Position oldPosition = getPosition();
                movements.randomMove(oldPosition);
                Position newPosition = getPosition();

//                if (getAppController().isFood(newPosition)) {
//                    increaseEnergy();
//                }


                decreaseEnergy();
            }
            try {
                Thread.sleep(1000);
//                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

    private boolean isFullOfEnergy() {
        return getEnergy() >= 100;
    }

    private void decreaseEnergy() {
        int energy = getEnergy();
        setEnergy(--energy);
    }

    private void increaseEnergy() {
        int energy = getEnergy();
        setEnergy(5 + energy);
    }

    private boolean isMoving() {
        int i = ThreadLocalRandom.current().nextInt(0, 10);//have 90% to move
        return i != 5;
    }
}
