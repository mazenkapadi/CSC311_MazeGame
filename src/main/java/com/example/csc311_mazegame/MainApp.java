package com.example.csc311_mazegame;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        loadMainScreen();
        primaryStage.setTitle("Maze Game");
        primaryStage.show();
    }

    private void loadMainScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
        Parent root = loader.load();
        MainScreenController mainScreenController = loader.getController();
        mainScreenController.setMainApp(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public void loadMaze(String mazeName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(mazeName + ".fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
