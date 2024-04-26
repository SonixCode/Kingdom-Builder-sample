package com.example.grid.GameBoard;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class Hexa extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Define the parameters of the hexagon
        double centerX = 200; // adjust this as needed
        double centerY = 200; // adjust this as needed
        double size = 50; // adjust this as needed
        double xOffset = size * Math.sqrt(3);
        double yOffset = size * 1.5;

        // Creating a Group to hold all hexagons
        Group root = new Group();

        // Creating the hexagonal grid
        int numRows = 5; // adjust this as needed
        int numCols = 5; // adjust this as needed
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double x = centerX + j * xOffset;
                double y = centerY + i * yOffset;
                if (i % 2 == 1) {
                    x += xOffset / 2;
                }
                Polygon hexagon = createHexagon(x, y, size);
                root.getChildren().add(hexagon);
            }
        }

        // Creating a Scene by passing the group object, width and height
        Scene scene = new Scene(root, 500, 500);

        // Setting the title to Stage.
        primaryStage.setTitle("Hexagonal Board");

        // Adding the scene to Stage
        primaryStage.setScene(scene);

        // Displaying the contents of the stage
        primaryStage.show();
    }

    private Polygon createHexagon(double centerX, double centerY, double size) {
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle_deg = 60 * i - 30;
            double angle_rad = Math.toRadians(angle_deg);
            double x = centerX + size * Math.cos(angle_rad);
            double y = centerY + size * Math.sin(angle_rad);
            hexagon.getPoints().addAll(x, y);
        }
        hexagon.setFill(Color.TRANSPARENT);
        hexagon.setStroke(Color.BLACK);
        return hexagon;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
