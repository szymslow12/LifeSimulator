package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import com.codecool.lifeSimulator.view.PlanetRender;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class AppController extends Pane{
    private Planet planet;
    private PlanetRender render;

    public AppController() {
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        generatePlanet(51, 92);
        renderPlanetState();
        runThreads();
    }


    private void generatePlanet(int height, int width) {
        planet = new Planet(height, width);
        planet.generatePlanetState();
    }


    private void renderPlanetState() {
        render = new PlanetRender();
        render.addPlanetStateToScene(this);
    }


    private void runThreads() {
        new MapUpdater(this).start();
        new FoodGenerator(this).start();
    }

  
    public synchronized Planet getPlanet() {
        return planet;
    }


    public synchronized void generateFoodOnRandomPosition() throws InterruptedException {
        if (render.getFlag()) {
            wait();
        }
        Thread.sleep(1000);
        planet.generateFoodOnRandomPosition();
        render.setFlag(true);
        notify();
    }


    public synchronized void updatePlanetState() throws InterruptedException {
        if (!render.getFlag()) {
            wait();
        }
        Thread.sleep(10000);
        render.update(planet.getPlanetState(), this);
        render.setFlag(false);
        notifyAll();
    }
}
