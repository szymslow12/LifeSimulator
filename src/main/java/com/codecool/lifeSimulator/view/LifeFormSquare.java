package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LifeFormSquare extends SquareView {

    public LifeFormSquare(Square square) {
        super(square);
    }

    @Override
    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        context.strokeRect(0, 0, squareSide, squareSide);
        float lifePos = squareSide / 4;
        context.setFill(Color.web("#ff0000"));
        context.fillOval(lifePos, lifePos, 10,10);
        context.setFill(Color.web("#000000"));
        context.setFont(new Font(5));
        context.fillText("Energy: " + getSquare().getEnergy(), translatePos, translatePos * 6);
    }
}
