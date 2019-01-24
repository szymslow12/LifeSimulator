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

    public void setBlank(Position pos) {
        planetState[pos.getY()][pos.getX()] = new Blank(pos.getX(), pos.getY());
    }

    public void setNewState(LifeForm lifeForm) {
        int y = lifeForm.getPosition().getY();
        int x = lifeForm.getPosition().getX();
        planetState[y][x] = lifeForm;
    }
}
