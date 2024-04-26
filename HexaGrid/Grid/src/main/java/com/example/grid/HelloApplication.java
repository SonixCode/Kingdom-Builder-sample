package com.example.grid;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Polygon[][] hexagons; // create an Array of hexagons type to store the position

    @Override
    public void start(Stage primaryStage) {
        double centerX = 50;
        double centerY = 50;
        double size = 34;
        double xOffset = size * Math.sqrt(3);
        double yOffset = size * 1.5;

        Group root = new Group();

        int numRows = 20;
        int numCols = 20;

        hexagons = new Polygon[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double x = centerX + j * xOffset;
                double y = centerY + i * yOffset;
                if (i % 2 == 1) {
                    x += xOffset / 2;
                }
                Polygon hexagon = createHexagon(x, y, size);
                root.getChildren().add(hexagon);
                // Store the position of each hexagon
                hexagons[i][j] = hexagon;
                hexagon.setOnMouseClicked(event -> {
                    if (event.getButton() == MouseButton.PRIMARY) {
                        hexagon.setFill(Color.AZURE);
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        hexagon.setFill(Color.TRANSPARENT);
                    }
                });
            }
        }
        colorHexagon(0, 0, Color.YELLOW);
        colorHexagon(0, 1, Color.YELLOW);
        colorHexagon(1, 0, Color.YELLOW);

        Color BROWN = Color.rgb(102, 51, 0);
        colorHexagon(0, 2, BROWN);
        colorHexagon(1, 2, BROWN);
        colorHexagon(2, 0, BROWN);
        colorHexagon(2, 1, BROWN);
        colorHexagon(2, 2, BROWN);
        colorHexagon(3, 0, BROWN);
        colorHexagon(3, 1, BROWN);

        Scene scene = new Scene(root, 1000, 1000);

        primaryStage.setTitle("Hexagonal Board");

        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);

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
        hexagon.setFill(Color.GRAY);
        hexagon.setStroke(Color.BLACK);
        return hexagon;
    }
    private void colorHexagon(int rowIndex, int colIndex, Color color) {
        if (rowIndex >= 0 && rowIndex < hexagons.length &&
                colIndex >= 0 && colIndex < hexagons[0].length) {
            hexagons[rowIndex][colIndex].setFill(color);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
