package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.GraphicsContext;

public class Blank extends Square {

    public Blank(int posX, int poxY) {
        super("BLANK", 0, posX, poxY);
    }


    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        context.strokeRect(0, 0, squareSide, squareSide);
    }
}
