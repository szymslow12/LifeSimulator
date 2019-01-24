package com.codecool.lifeSimulator.model.squareLogic;

import com.codecool.lifeSimulator.model.Position;

public class SquareState {

    private Square[][] planetState;

    public SquareState(Square[][] planetState) {
        this.planetState = planetState;
    }

    public boolean isFood(Position pos) {
        return planetState[pos.getY()][pos.getX()] instanceof Food;
    }

    public boolean isLifeForm(Position pos) {
        return planetState[pos.getY()][pos.getX()] instanceof LifeForm;
    }
}
