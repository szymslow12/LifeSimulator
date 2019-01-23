package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.controller.AppController;
import com.codecool.lifeSimulator.model.squareLogic.Square;
import javafx.application.Platform;

import java.util.stream.Stream;

public class PlanetRender implements Runnable {
    private AppController appController;
    private volatile boolean isRunning = true;

    public PlanetRender(AppController appController) {
        this.appController = appController;
    }


//    public void renderPlanetScene() {
//        Square[][] planetState = appController.getPlanet().getPlanetState();
//        appController.getChildren().clear();
//        Stream.of(planetState).forEach(
//            line -> Stream.of(line).forEach(
//                square -> appController.getChildren().add(SquareView.renderSquare(square))
//            )
//        );
//    }

    private void renderScene(Square[][] planetState) {
        Platform.runLater(() -> updateGameWindow(planetState, appController));
    }


    private void updateGameWindow(Square[][] planetState, AppController controller) {
        controller.getChildren().clear();
        Stream.of(planetState).forEach(line -> Stream.of(line).forEach(square -> controller.getChildren().add(SquareView.renderSquare(square))));
//        IntStream.range(0, controller.getChildren().size()).forEach(i -> updateCanvasSquare(i, planetState, controller));
    }

    @Override
    public synchronized void run() {

        while (isRunning) {
            renderScene(appController.getPlanet().getPlanetState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }

    }


//    private void updateCanvasSquare(int index, Square[][] planetState, AppController controller) {
//        Node square = controller.getChildren().get(index);
//        long y = Math.round((square.getLayoutY() - 5) / 20);
//        long x = Math.round((square.getLayoutX() - 7.5) / 20);
//        double squareY = planetState[(int) y][(int) x].getPosition().getY() * 20;
//        double squareX = planetState[(int) y][(int) x].getPosition().getX() * 20;
//        SquareView canvas = SquareView.renderSquare(planetState[(int) y][(int) x]);
//        controller.getChildren().remove(square);
//        controller.getChildren().add(canvas);
//    }

}
