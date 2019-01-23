package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.FoodGenerator;
import com.codecool.lifeSimulator.model.Planet;
import com.codecool.lifeSimulator.view.PlanetRender;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AppController extends Pane {
    private Planet planet;

    public AppController() {
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        planet = new Planet(51, 92);
        runThreads();
    }

    private void runThreads() {
        (new Thread(new PlanetRender(this))).start();
        (new Thread(new FoodGenerator(this))).start();
    }


    public synchronized Planet getPlanet() {
        return planet;
    }

}
