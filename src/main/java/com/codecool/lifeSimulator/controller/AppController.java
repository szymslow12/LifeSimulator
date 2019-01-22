package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import com.codecool.lifeSimulator.view.PlanetRender;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AppController extends Pane implements Runnable{
    private Planet planet;
    private PlanetRender render;

    public AppController() {
        planet = new Planet(10, 10);
        planet.generatePlanetState();
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        render = new PlanetRender();
        render.addPlanetStateToScene(this);
        new Thread(this, "AppController").start();
    }

  
    public synchronized Planet getPlanet() {
        return planet;
    }



    public void run() {
        while(true) {
            Square[][] planetState = planet.getPlanetState();
            AppController.shufflePositions(planetState);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
            render.update(planetState, this);
        }

    }


    private static void shufflePositions(Square[][] array)
    {
        Random random = new Random();
        List<Position> positions = new LinkedList<Position>() {
            private void addPositions() {
                IntStream.range(0, 10).forEach(y -> IntStream.range(0, 10).forEach(x -> add(new Position(x, y))));
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
