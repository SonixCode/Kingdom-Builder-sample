package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void main(String[] args) {
        Application.launch(args);

    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        // create a root Node based on our FXML files
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/demo/sample.fxml"));
        // link the fxml to this class
        primaryStage.setTitle("Example");
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }
}