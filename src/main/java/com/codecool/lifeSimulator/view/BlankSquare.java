package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.squareLogic.Square;
import javafx.scene.canvas.GraphicsContext;

public class BlankSquare extends SquareView {

    public BlankSquare(Square square) {
        super(square);
    }


    @Override
    void drawShape(GraphicsContext context, float squareSide, float translatePos) {
        context.strokeRect(0, 0, squareSide, squareSide);
    }
}
