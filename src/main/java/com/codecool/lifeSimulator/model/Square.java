package com.codecool.lifeSimulator.model;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public abstract class Square {

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
        GraphicsContext context = canvas.getGraphicsContext2D();
        // 96 because square has 4 sides and each side has line with 1px size
        drawShape(context, 96, 1.5f);
        setCanvasProperties(canvas);
        return canvas;
    }


    private void setCanvasProperties(Canvas canvas) {
        float canvasX = position.getX() * 100;
        float canvasY = position.getY() * 100;
        canvas.setLayoutX(canvasX + 10);
        canvas.setLayoutY(canvasY + 10);
        canvas.setEffect(new DropShadow(15, Color.web("#000000")));
    }


    /*private void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        context.strokeRect(0, 0, squareSide, squareSide);
        if (name.equals("FOOD")) {
            float squareFillSize = squareSide - translatePos - 0.5f;
            context.setFill(Color.web("#00e64d"));
            context.fillRect(translatePos,translatePos, squareFillSize, squareFillSize);
        } else if (name.equals("LIFE")) {
            float lifePos = squareSide / 4;
            context.setFill(Color.web("#ff0000"));
            context.fillOval(lifePos, lifePos, 50,50);
            context.setFill(Color.web("#000000"));
            context.setFont(new Font(10));
            context.fillText("Energy: " + energy, translatePos, translatePos * 6);
        }
    }*/

    abstract void drawShape(GraphicsContext context, float squareSide, float translatePos);

    @Override
    public String toString() {
        return String.format("Square: name=%s, energy=%s, position=%s", name, energy, position);
    }
}
