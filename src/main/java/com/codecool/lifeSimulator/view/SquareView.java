package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Square;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;

public abstract class SquareView extends Canvas {
    private Square square;

    public SquareView(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return square;
    }

    private Canvas getSquareCanvas() {
        Canvas canvas = new Canvas(100, 100);
        GraphicsContext context = canvas.getGraphicsContext2D();
        // 96 because square has 4 sides and each side has line with 1px size
        drawShape(context, 96, 1.5f);
        setCanvasProperties(canvas);
        return canvas;
    }


    private void setCanvasProperties(Canvas canvas) {
        float canvasX = square.getPosition().getX() * 100;
        float canvasY = square.getPosition().getY() * 100;
        canvas.setLayoutX(canvasX + 10);
        canvas.setLayoutY(canvasY + 10);
        canvas.setEffect(new DropShadow(15, Color.web("#000000")));
    }


    abstract void drawShape(GraphicsContext context, float squareSide, float translatePos);
}
