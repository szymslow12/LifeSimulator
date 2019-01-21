package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.Planet;
import com.codecool.lifeSimulator.model.Square;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.util.stream.Stream;

public class AppController extends Pane {
    private Planet planet;

    public AppController() {
        planet = new Planet(10, 10);
        planet.generatePlanetState();
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        addPlanetStateToScene();
//        getStyleClass().add("square-container");
    }

    public void run() {
        System.out.println(planet);
    }


    private void addPlanetStateToScene() {
        Square[][] planetState = planet.getPlanetState();
        Stream.of(planetState).forEach(line -> Stream.of(line).forEach(square -> getChildren().add(square.getSquareCanvas())));
    }
}
