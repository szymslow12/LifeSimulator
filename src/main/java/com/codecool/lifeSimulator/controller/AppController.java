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
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        generatePlanet(51, 92);
        renderPlanetState();
        runThreads();
    }


    private void generatePlanet(int height, int width) {
        planet = new Planet(height, width);
        planet.generatePlanetState();
    }


    private void renderPlanetState() {
        render = new PlanetRender();
        render.addPlanetStateToScene(this);
    }


    private void runThreads() {
        new MapUpdater(this).start();
//        new MapShuffle(this).start();
        new FoodGenerator(planet, render).start();
    }

  
    public synchronized Planet getPlanet() {
        return planet;
    }


    public synchronized void updatePlanetState() throws InterruptedException {
        if (!render.getFlag()) {
            System.out.println(Thread.currentThread().getName() + " waits");
            wait();
        }
        System.out.println(Thread.currentThread().getName() + " started updating map!");
        render.update(planet.getPlanetState(), this);
        render.setFlag(false);
        System.out.println("Map updated!");
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
