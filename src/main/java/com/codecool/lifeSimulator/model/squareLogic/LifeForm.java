package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.model.Position;
import com.codecool.lifeSimulator.model.moves.Movements;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LifeForm extends Square implements Runnable {
    private volatile boolean isRunning = true;
    private Movements movements;
    private Square[][] planetState;
    private SquareState squareState;
    private List<LifeForm> lifeFormList;

    public LifeForm(int posX, int poxY,Square[][] planetState, List<LifeForm> lifeFormList) {
        super("LIFE_FORM", 110, posX, poxY);
        this.planetState = planetState;
        movements = new Movements();
        squareState = new SquareState(planetState);
        this.lifeFormList = lifeFormList;
    }

    @Override
    public synchronized void run() {

        while (isRunning) {

            if(getEnergy() <= 0) {
                squareState.setBlank(getPosition());
                isRunning = false;
                lifeFormList.remove(this);
                break;
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
                    lifeFormList.remove(this);
                }
                if (isReadyToSplit()) {
                    System.out.println("born");
                    this.setEnergy(100);
                    splitIntoTwoForm(oldPosition);
//                    break;
                } else {
                    squareState.setBlank(oldPosition);
                }

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

    private boolean isReadyToSplit() {
        return getEnergy() >= 120;
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

    private void splitIntoTwoForm(Position pos) {
        LifeForm lifeForm = new LifeForm(pos.getX(), pos.getY(), planetState, lifeFormList);
        lifeFormList.add(lifeForm);
//        planetState[pos.getY()][pos.getX()] = lifeForm;
        (new Thread(lifeForm)).start();
    }
}
