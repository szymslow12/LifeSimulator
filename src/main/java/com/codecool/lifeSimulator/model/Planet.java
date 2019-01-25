package com.codecool.lifeSimulator.model;

import com.codecool.lifeSimulator.model.squareLogic.LifeForm;
import com.codecool.lifeSimulator.model.squareLogic.Square;

import java.util.ArrayList;
import java.util.List;

public class Planet {
    private Square[][] planetState;
    private List<LifeForm> lifeFormList;

    public Square[][] getPlanetState() {
        return planetState;
    }

    public Planet(int planetHeight, int planetWidth) {
        this.lifeFormList = new ArrayList<>();
        planetState = new Square[planetHeight][planetWidth];
        generatePlanetState();

    }

    public List<LifeForm> getLifeFormList() {
        return lifeFormList;
    }

    private void generatePlanetState() {
        FillingMap fillingMap = new FillingMap(planetState, lifeFormList);
        fillingMap.fillMap(20, 4);
    }

}
