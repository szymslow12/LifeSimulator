package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.Planet;
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
    }

    public void run() {
        System.out.println(planet);
    }
}
