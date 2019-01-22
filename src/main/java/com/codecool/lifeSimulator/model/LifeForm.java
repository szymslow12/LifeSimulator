package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LifeForm extends Square {

    public LifeForm() {
        super("LIFE_FORM", 100);
    }


    @Override
    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        context.strokeRect(0, 0, squareSide, squareSide);
        float lifePos = squareSide / 4;
        context.setFill(Color.web("#ff0000"));
        context.fillOval(lifePos, lifePos, 50,50);
        context.setFill(Color.web("#000000"));
        context.setFont(new Font(10));
        context.fillText("Energy: " + getEnergy(), translatePos, translatePos * 6);
    }
}
