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


    private void renderScene(Square[][] planetState) {
        Platform.runLater(() -> updateGameWindow(planetState, appController));
    }


    private void updateGameWindow(Square[][] planetState, AppController controller) {
//        controller.getChildren().clear();
//        Stream.of(planetState).forEach(
//            line -> Stream.of(line).forEach(
//                square -> controller.getChildren().add(SquareView.renderSquare(square))
//            )
//        );
        controller.getChildren().stream().forEach(square -> checkAndReplace((SquareView) square, planetState, controller));
    }


    private void checkAndReplace(SquareView view, Square[][] planetState, AppController controller) {
        Stream.of(planetState).forEach(
            squareLine -> Stream.of(squareLine).forEach(
                square -> {
                    Square viewSquare = view.getSquare();
                    if (!viewSquare.getName().equals(square.getName()) && viewSquare.isPositionEqual(square)) {
                        controller.getChildren().remove(view);
                        controller.getChildren().add(SquareView.renderSquare(square));
                    }
                }
            )
        );
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
}
