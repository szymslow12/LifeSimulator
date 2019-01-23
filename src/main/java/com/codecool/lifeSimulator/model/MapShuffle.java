package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public class MapShuffle extends Thread {

    private AppController controller;

    public MapShuffle(AppController controller) {
        this.controller = controller;
        setName("MapShuffle");
    }


    @Override
    public void run() {
        while(true) {
            try {
                controller.shufflePlanetState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
