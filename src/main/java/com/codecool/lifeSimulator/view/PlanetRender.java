package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.Food;
import com.codecool.lifeSimulator.model.LifeForm;
import com.codecool.lifeSimulator.model.Square;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;

import java.util.stream.Stream;

public class PlanetRender {


    public void addPlanetStateToScene(AppController controller) {
        Square[][] planetState = controller.getPlanet().getPlanetState();
        //for tests
        planetState[0][4] = new Food(4, 0);
        planetState[4][1] = new Food(1, 4);
        planetState[4][4] = new LifeForm(4, 4);
        Stream.of(planetState).forEach(
                line -> Stream.of(line).forEach(
                        square -> controller.getChildren().add(square.getCanvas())
                )
        );
    }


    public void updateGameWindow(Square[][] planetState, AppController controller) {
        controller.getChildren().parallelStream().forEach(square -> updateCanvasSquare(square, planetState));
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

}
