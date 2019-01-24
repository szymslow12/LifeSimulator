package com.codecool.lifeSimulator;

import com.codecool.lifeSimulator.controller.AppController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AppController appController = new AppController();
        Scene scene = new Scene(appController.getPlanetView());
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Life Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
