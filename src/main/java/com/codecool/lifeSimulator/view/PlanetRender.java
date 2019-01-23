package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.Square;
import javafx.application.Platform;
import javafx.scene.Node;

import java.util.stream.Stream;

public class PlanetRender {

    private boolean flag;

    public PlanetRender() {
        flag = false;
    }


    public void addPlanetStateToScene(AppController controller) {
        Square[][] planetState = controller.getPlanet().getPlanetState();
        Stream.of(planetState).forEach(
            line -> Stream.of(line).forEach(
                square -> controller.getChildren().add(SquareView.renderSquare(square))
            )
        );
    }


    public void setFlag(boolean flag) {
        this.flag = flag;
    }


    public boolean getFlag() {
        return flag;
    }


    public void update(Square[][] planetState, AppController controller) {
        Platform.runLater(() -> updateGameWindow(planetState, controller));
    }


    public void updateGameWindow(Square[][] planetState, AppController controller) {
        controller.getChildren().clear();
        Stream.of(planetState).forEach(line -> Stream.of(line).forEach(square -> controller.getChildren().add(SquareView.renderSquare(square))));
//        IntStream.range(0, controller.getChildren().size()).forEach(i -> updateCanvasSquare(i, planetState, controller));
    }


    private void updateCanvasSquare(int index, Square[][] planetState, AppController controller) {
        Node square = controller.getChildren().get(index);
        long y = Math.round((square.getLayoutY() - 5) / 20);
        long x = Math.round((square.getLayoutX() - 7.5) / 20);
        double squareY = planetState[(int) y][(int) x].getPosition().getY() * 20;
        double squareX = planetState[(int) y][(int) x].getPosition().getX() * 20;
        SquareView canvas = SquareView.renderSquare(planetState[(int) y][(int) x]);
        controller.getChildren().remove(square);
        controller.getChildren().add(canvas);
    }

}
