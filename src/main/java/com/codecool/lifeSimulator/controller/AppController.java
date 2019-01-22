package com.codecool.lifeSimulator.controller;

import com.codecool.lifeSimulator.model.*;
import com.codecool.lifeSimulator.view.PlanetRender;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Random;

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
            AppController.shuffleArray(planetState);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            render.updateGameWindow(planetState, this);
        }
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
