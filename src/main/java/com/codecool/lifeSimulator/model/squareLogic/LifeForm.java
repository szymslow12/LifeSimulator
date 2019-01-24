package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.model.Position;
import com.codecool.lifeSimulator.model.moves.Movements;

import java.util.concurrent.ThreadLocalRandom;

public class LifeForm extends Square implements Runnable {
    private volatile boolean isRunning = true;
    private Movements movements;
    private Square[][] planetState;
    private SquareState squareState;

    public LifeForm(int posX, int poxY, Square[][] planetState) {
        super("LIFE_FORM", 90, posX, poxY);
        this.planetState = planetState;
        movements = new Movements();
        squareState = new SquareState(planetState);
    }

    private void splitIntoTwoForm() {
        int x = getPosition().getX();
        int y = getPosition().getY();
        LifeForm lifeForm = new LifeForm(x, y, planetState);
        planetState[y][x] = lifeForm;
        (new Thread(lifeForm)).start();
    }

    @Override
    public synchronized void run() {

        while (isRunning) {
            if (isFullOfEnergy()) {
                splitIntoTwoForm();
            }
            if(getEnergy() == 0) {
                isRunning = false;
            }
            decreaseEnergy();
            if (isMoving()) {

                Position oldPosition = getPosition();
                movements.randomMove(oldPosition);
                Position newPosition = getPosition();

                if(squareState.isFood(newPosition)){
                    increaseEnergy();
                }

                else if(squareState.isLifeForm(newPosition)){
                    isRunning = false;
                }
                setBlank(oldPosition);
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

    private void setBlank(Position pos){
        planetState[pos.getY()][pos.getX()] = new Blank(pos.getX(), pos.getY());
    }
}
