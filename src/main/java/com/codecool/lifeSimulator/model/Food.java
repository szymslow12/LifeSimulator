package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Food extends Square {

    public Food() {
        super("FOOD", 5);
    }


    @Override
    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        float squareFillSize = squareSide - translatePos - 0.5f;
        context.strokeRect(0, 0, squareSide, squareSide);
        context.setFill(Color.web("#00e64d"));
        context.fillRect(translatePos,translatePos, squareFillSize, squareFillSize);
    }
}
