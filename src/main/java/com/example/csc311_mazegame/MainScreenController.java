package com.example.csc311_mazegame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MainScreenController {
    private MainApp mainApp;

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void loadMaze1(ActionEvent event) throws IOException {
        mainApp.loadMaze("Maze1");
    }

    @FXML
    private void loadMaze2(ActionEvent event) throws IOException {
        mainApp.loadMaze("Maze2");
    }
}
