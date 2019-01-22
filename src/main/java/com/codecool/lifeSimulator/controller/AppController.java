package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.stream.Stream;

public class AppController extends Pane {
    private Planet planet;

    public AppController() {
        planet = new Planet(10, 10);
        planet.generatePlanetState();
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        addPlanetStateToScene();
    }

    public void run() {
        System.out.println(planet);
    }


    private void addPlanetStateToScene() {
        Square[][] planetState = planet.getPlanetState();
        //for tests
        planetState[0][4] = new Food();
        planetState[0][4].setPosition(new Position(4, 0));
        planetState[4][1] = new Food();
        planetState[4][1].setPosition(new Position(1, 4));
        planetState[4][4] = new LifeForm();
        planetState[4][4].setPosition(new Position(4, 4));
        Stream.of(planetState).forEach(
            line -> Stream.of(line).forEach(
                square -> getChildren().add(square.getSquareCanvas())
            )
        );
    }
}
