package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public interface CommandMoves {
    int planetHight = 10;
    int planetWidth = 10;

    void move(Position position);
}
