package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Random;
import java.util.stream.Stream;

public class AppController extends Pane implements Runnable{
    private Planet planet;

    public AppController() {
        planet = new Planet(10, 10);
        planet.generatePlanetState();
        setBackground(new Background(new BackgroundFill(Color.web("#ffffff"), CornerRadii.EMPTY, Insets.EMPTY)));
        addPlanetStateToScene();
        new Thread(this, "AppController").start();

    }


    private void addPlanetStateToScene() {
        Square[][] planetState = planet.getPlanetState();
        //for tests
        planetState[0][4] = new Food();
        planetState[0][4].setPosition(new Position(4, 0));
        planetState[4][1] = new Food();
        planetState[4][1].setPosition(new Position(1, 4));
        planetState[4][4] = new LifeForm();
        planetState[4][4].setPosition(new Position(4, 4));
        Stream.of(planetState).forEach(
            line -> Stream.of(line).forEach(
                square -> getChildren().add(square.getCanvas())
            )
        );
    }


    public synchronized Planet getPlanet() {
        return planet;
    }

  
    public void run() {
        while(true) {
            Square[][] planetState = planet.getPlanetState();
            AppController.shuffleArray(planetState);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateGameWindow(planetState);
        }
    }

    private void updateGameWindow(Square[][] planetState) {
        Square food = new Food();
        food.setPosition(new Position(1 , 4));
        getChildren().parallelStream().forEach(square -> updateCanvasSquare(square, planetState));
    }


    private void updateCanvasSquare(Node square, Square[][] planetState) {
        long y = Math.round((square.getLayoutY() - 10) / 100);
        long x = Math.round((square.getLayoutX() - 10) / 100);
        double squareY = planetState[(int) y][(int) x].getPosition().getY() * 100;
        double squareX = planetState[(int) y][(int) x].getPosition().getX() * 100;
        Canvas canvas = planetState[(int) y][(int) x].getCanvas();
        canvas.setLayoutX(squareX + 10);
        canvas.setLayoutY(squareY + 10);
//        square.setLayoutX(squareX + 10);
//        square.setLayoutY(squareY + 10);

    }


    private static void shuffleArray(Square[][] array)
    {
        int index;
        Square temp;
        Random random = new Random();
        /*for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }*/
        for (Square[] line: array) {
            for (int i = 0; i < line.length; i++) {
                index = random.nextInt( line.length);
                if (index == line.length) {
                    System.out.println("Index = " + index);
                    break;
                }
                temp = line[index];
                System.out.println(line[index].getPosition() + " changed to " + line[i].getPosition());
                line[index].setPosition(line[i].getPosition());
                System.out.println(line[i].getPosition() + " changed to " + temp.getPosition());
                line[i].setPosition(temp.getPosition());
            }
        }
    }
}
