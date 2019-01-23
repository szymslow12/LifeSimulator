package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.FoodGenerator;
import com.codecool.lifeSimulator.model.Planet;
import com.codecool.lifeSimulator.model.Position;
import com.codecool.lifeSimulator.model.squareLogic.Food;
import com.codecool.lifeSimulator.model.squareLogic.Square;
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
        planet = new Planet(51, 92, this);
        runThreads();
    }

    private void runThreads() {
        (new Thread(new PlanetRender(this))).start();
        (new Thread(new FoodGenerator(this))).start();
    }

    public synchronized Planet getPlanet() {
        return planet;
    }


    public synchronized boolean isFood(Position pos){
        Square[][] planetState = planet.getPlanetState();
        return planetState[pos.getY()][pos.getX()] instanceof Food;
    }

    public synchronized void changeState(Position pos1, Position pos2) {
        Square[][] planetState = planet.getPlanetState();
        if(planetState[pos1.getY()][pos1.getX()] instanceof Food) {

        }
    }
}
