package com.codecool.lifeSimulator.view;

import com.codecool.lifeSimulator.model.squareLogic.Square;
import javafx.application.Platform;

import java.util.stream.Stream;

public class PlanetRender implements Runnable {
    private PlanetView view;
    private volatile boolean isRunning = true;

    public PlanetRender(PlanetView view) {
        this.view = view;
    }


    private void renderScene(Square[][] planetState) {
        Platform.runLater(() -> updateGameWindow(planetState, view));
    }


    private void updateGameWindow(Square[][] planetState, PlanetView view) {
        view.getChildren().clear();
        Stream.of(planetState).forEach(
                line -> Stream.of(line).forEach(
                        square -> view.getChildren().add(SquareView.renderSquare(square))
                )
        );
    }

    @Override
    public synchronized void run() {

        while (isRunning) {
            renderScene(view.getPlanet().getPlanetState());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            notifyAll();
        }

    }
}
