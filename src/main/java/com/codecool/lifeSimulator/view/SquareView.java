package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Square;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public abstract class SquareView extends Canvas {
    private Square square;

    public SquareView(Square square) {
        super(100, 100);
        this.square = square;
        renderSquare();
    }

    public Square getSquare() {
        return square;
    }


    public void setSquare(Square square) {
        this.square = square;
    }

    private void renderSquare() {
        GraphicsContext context = getGraphicsContext2D();
        // 96 because square has 4 sides and each side has line with 1px size
        drawShape(context, 96, 1.5f);
        setCanvasProperties();
    }


    private void setCanvasProperties() {
        float canvasX = square.getPosition().getX() * 100;
        float canvasY = square.getPosition().getY() * 100;
        setLayoutX(canvasX + 10);
        setLayoutY(canvasY + 10);
        setEffect(new DropShadow(15, Color.web("#000000")));
    }


    abstract void drawShape(GraphicsContext context, float squareSide, float translatePos);


    public static SquareView renderSquare(Square square) {
        switch (square.getName()) {
            case "BLANK":
                return new BlankSquare(square);
            case "FOOD":
                return new FoodSquare(square);
            case "LIFE_FORM":
                return new LifeFormSquare(square);
            default:
                return new BlankSquare(square);
        }
    }
}
