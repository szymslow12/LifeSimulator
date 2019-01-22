package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.controller.AppController;

public interface CommandMoves {
    int planetHight = new AppController().getPlanet().getPlanetState().length;
    int planetWidth = new AppController().getPlanet().getPlanetState()[0].length;

    void move(Position position);
}
