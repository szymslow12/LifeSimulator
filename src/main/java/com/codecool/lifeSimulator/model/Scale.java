package com.codecool.lifeSimulator.model;

import javafx.beans.property.DoubleProperty;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class Scale {

    private DoubleProperty viewScale;
    private final double ZOOM_DEC = 0.02;

    public Scale(DoubleProperty viewScale) {
        this.viewScale = viewScale;
    }


    public DoubleProperty getViewScale() {
        return viewScale;
    }


    public EventHandler<ScrollEvent> handleZoom = (ScrollEvent event) -> {
        double scaleY = viewScale.getValue();
        double inputDeltaY = event.getDeltaY();
        System.out.println("ScaleY=" + scaleY + " InputDeltaY=" + inputDeltaY);
        if (inputDeltaY < 0 && scaleY > 0.50) {
            viewScale.subtract(ZOOM_DEC);
        } else if (inputDeltaY > 0) {
            viewScale.add(ZOOM_DEC);
        }
    };
}
