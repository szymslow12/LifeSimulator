package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import com.codecool.lifeSimulator.view.PlanetRender;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppController extends Pane{
    private Planet planet;
    private PlanetRender render;

    public AppController() {
        planet = new Planet(51, 92);
        planet.generatePlanetState();
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        render = new PlanetRender();
        render.addPlanetStateToScene(this);
        new MapUpdater(this).start();
//        new MapShuffle(this).start();
    }

  
    public synchronized Planet getPlanet() {
        return planet;
    }


    public synchronized void updatePlanetState() throws InterruptedException {
        if (!render.getFlag()) {
            wait();
        }
        Thread.sleep(1000);
        render.update(planet.getPlanetState(), this);
        render.setFlag(false);
        notify();
    }


    public synchronized void shufflePlanetState() throws InterruptedException {
        if (render.getFlag()) {
            wait();
        }
        AppController.shufflePositions(planet.getPlanetState());
        render.setFlag(true);
        notify();
    }


    private static void shufflePositions(Square[][] array)
    {
        Random random = new Random();
        List<Position> positions = new LinkedList<Position>() {
            private void addPositions() {
                IntStream.range(0, 51).forEach(y -> IntStream.range(0, 92).forEach(x -> add(new Position(x, y))));
                Collections.shuffle(this);
            }

            {
                addPositions();
            }
        };
        Stream.of(array).forEach(line -> Stream.of(line).forEach(square -> changePosition(square, positions, random)));
    }

    private static void changePosition(Square square, List<Position> positions, Random random) {
        int index = random.nextInt(positions.size());
        Position position = positions.get(index);
        positions.remove(index);
        square.setPosition(position);

    }
}
