package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Planet;
import com.codecool.lifeSimulator.model.Scale;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class PlanetView extends Pane {



    private Planet planet;
    private Scale scale;

    public PlanetView(Planet planet) {
        this.planet = planet;
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        scale = new Scale(new SimpleDoubleProperty(1.0));
        scaleYProperty().bind(scale.getViewScale());
        scaleXProperty().bind(scale.getViewScale());
        setOnScroll(scale.handleZoom);
    }


    public Planet getPlanet() {
        return planet;
    }
}
