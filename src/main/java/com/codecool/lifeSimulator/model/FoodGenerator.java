package com.codecool.lifeSimulator.model;

public class FoodGenerator extends Thread{
    private Planet planet;

    public FoodGenerator(Planet planet) {
        this.planet = planet;
    }


    @Override
    public void run() {
        while (true) {
            try {
                planet.generateFoodOnRandomPosition();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
