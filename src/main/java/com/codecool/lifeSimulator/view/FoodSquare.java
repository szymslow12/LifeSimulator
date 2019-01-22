package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.Square;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class FoodSquare extends SquareView {

    public FoodSquare(Square square) {
        super(square);
    }


    @Override
    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        float squareFillSize = squareSide - translatePos - 0.5f;
        context.strokeRect(0, 0, squareSide, squareSide);
        context.setFill(Color.web("#00e64d"));
        context.fillRect(translatePos,translatePos, squareFillSize, squareFillSize);
    }
}
