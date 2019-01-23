package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public class FoodGenerator extends Thread{
    private AppController controller;

    public FoodGenerator(AppController controller) {
        this.controller = controller;
        setName("FoodGenerator");
    }


    @Override
    public void run() {
        while (true) {
            try {
                controller.generateFoodOnRandomPosition();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
