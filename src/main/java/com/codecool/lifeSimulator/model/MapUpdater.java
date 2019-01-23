package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public class MapUpdater extends Thread {
    private AppController controller;

    public MapUpdater(AppController controller) {
        this.controller = controller;
        setName("MapUpdater");
    }


    @Override
    public void run() {
        while (true) {
            try {
                controller.updatePlanetState();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
