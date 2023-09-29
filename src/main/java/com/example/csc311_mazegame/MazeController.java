package com.example.csc311_mazegame;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

public class MazeController {
    @FXML
    private ImageView mazeImageView1; // Add this field
    @FXML
    private ImageView mazeImageView2; // Add this field



    private double carX; // X-coordinate of the car
    private double carY; // Y-coordinate of the car

    private double robotX; // X-coordinate of the robot
    private double robotY; // Y-coordinate of the robot

    @FXML
    private void initialize() {
        if (mazeImageView1 != null) {
            // Initialize the car's starting position
            carX = 50.0;
            carY = 50.0;
            updateCarPosition();
        }

        if (mazeImageView2 != null) {
            robotX = 50.0;
            robotY = 50.0;
            updateRobotPosition();
        }
    }
    @FXML
    private void handleKeyPressMaze1(KeyEvent event) {
        if (mazeImageView1 != null) {
            KeyCode keyCode = event.getCode();

            // Adjust the rectangle's speed in Maze1
            double speed = 10.0;
            switch (keyCode) {
                case UP:
                    mazeImageView1.setY(mazeImageView1.getY() - speed);
                    break;
                case DOWN:
                    mazeImageView1.setY(mazeImageView1.getY() + speed);
                    break;
                case LEFT:
                    mazeImageView1.setX(mazeImageView1.getX() - speed);
                    break;
                case RIGHT:
                    mazeImageView1.setX(mazeImageView1.getX() + speed);
                    break;
                default:
                    break;
            }
        }
        // Update the car position in Maze1
        updateCarPosition();
    }

    @FXML
    private void handleKeyPressMaze2(KeyEvent event) {
        if (mazeImageView2 != null) {
            KeyCode keyCode = event.getCode();

            // Adjust the rectangle's speed in Maze2
            double speed = 10.0;
            switch (keyCode) {
                case UP:
                    mazeImageView2.setY(mazeImageView2.getY() - speed);
                    break;
                case DOWN:
                    mazeImageView2.setY(mazeImageView2.getY() + speed);
                    break;
                case LEFT:
                    mazeImageView2.setX(mazeImageView2.getX() - speed);
                    break;
                case RIGHT:
                    mazeImageView2.setX(mazeImageView2.getX() + speed);
                    break;
                default:
                    break;
            }
        }
        // Update the robot position in Maze2
        updateRobotPosition();
    }

    private Tab getSelectedTab() {
        // Get the currently selected tab from the Scene
        Scene scene = mazeImageView1.getScene();
        if (scene != null) {
            TabPane tabPane = (TabPane) scene.lookup("#tabPaneId"); // Replace "tabPaneId" with the actual ID of your TabPane in FXML
            if (tabPane != null) {
                return tabPane.getSelectionModel().getSelectedItem();
            }
        }
        return null;
    }

    @FXML
    private void updateCarPosition() {
        if (mazeImageView1 != null) {
            // Ensure the car stays within the maze boundaries in Maze1
            double mazeWidth = mazeImageView1.getParent().getLayoutBounds().getWidth();
            double mazeHeight = mazeImageView1.getParent().getLayoutBounds().getHeight();

            carX = Math.max(0, Math.min(carX, mazeWidth - mazeImageView1.getFitWidth()));
            carY = Math.max(0, Math.min(carY, mazeHeight - mazeImageView1.getFitHeight()));

            mazeImageView1.setLayoutX(carX);
            mazeImageView1.setLayoutY(carY);
        }
    }

    @FXML
    private void updateRobotPosition() {
        if (mazeImageView2 != null) {
            // Ensure the robot stays within the maze boundaries in Maze2
            double mazeWidth = mazeImageView2.getParent().getLayoutBounds().getWidth();
            double mazeHeight = mazeImageView2.getParent().getLayoutBounds().getHeight();

            robotX = Math.max(0, Math.min(robotX, mazeWidth - mazeImageView2.getFitWidth()));
            robotY = Math.max(0, Math.min(robotY, mazeHeight - mazeImageView2.getFitHeight()));

            mazeImageView2.setLayoutX(robotX);
            mazeImageView2.setLayoutY(robotY);
        }
    }
}
