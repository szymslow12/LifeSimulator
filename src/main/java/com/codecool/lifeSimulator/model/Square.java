package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public class Square {

    private String name;
    private int energy;
    private Position position;

    public Square() {
        this.name = "BLANK";
        this.energy = 0;
    }


    public Square(String name, int energy) {
        this.name = name;
        this.energy = energy;
    }

    public String getName() {
        return name;
    }


    public int getEnergy() {
        return energy;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public Position getPosition() {
        return position;
    }


    public Canvas getSquareCanvas() {
        Canvas canvas = new Canvas(100, 100);
        canvas.setEffect(new DropShadow(15, Color.web("#000000")));
        float canvasX = position.getX() * 100;
        float canvasY = position.getY() * 100;
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.strokeRect(0, 0, 100, 100);
        canvas.setLayoutX(canvasX);
        canvas.setLayoutY(canvasY);
        return canvas;
    }

    @Override
    public String toString() {
        return String.format("Square: name=%s, energy=%s, position=%s", name, energy, position);
    }
}
