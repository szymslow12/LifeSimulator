package com.codecool.lifeSimulator.model;

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
            System.out.println("dziala");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
