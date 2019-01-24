package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Planet;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PlanetView extends Pane {

    private Planet planet;

    public PlanetView(Planet planet) {
        this.planet = planet;
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
    }


    public Planet getPlanet() {
        return planet;
    }
}
