package com.example.demo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class HelloController extends Application {
    private Polygon[][] hexagons; // create an Array of hexagons type to store the position

    @Override
    public void start(Stage primaryStage) {
        double centerX = 50;
        double centerY = 50;
        double size = 27.5;
        double xOffset = size * Math.sqrt(3);
        double yOffset = size * 1.5;
        int numRows = 20;
        int numCols = 20;








        hexagons = new Polygon[numRows][numCols];
        Group root = new Group();
        //--------------------------------------- add background
        Image backgroundImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Background_zombie.jpg")));
        ImageView backgroundView = new ImageView(backgroundImage);
        backgroundView.fitWidthProperty().bind(primaryStage.widthProperty());
        backgroundView.fitHeightProperty().bind(primaryStage.heightProperty());
        root.getChildren().add(backgroundView);

        // initialize the board with hexagon (position)
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
                        hexagon.setFill(Color.RED);
                    } else if (event.getButton() == MouseButton.SECONDARY) {
                        hexagon.setFill(Color.WHEAT);
                    }
                });
            }
        }

        Color GRAY = Color.rgb(105, 105, 105);
        int[][] grayHexagonsIndices = {
                {7, 4}, {8, 1}, {11, 0}, {11, 1}, {12, 0}, {12, 1}, {13, 0}, {12, 3},
                {12, 4}, {13, 2}, {13, 5}, {14, 5}, {15, 7}, {14, 6}, {13, 3}, {18, 15},
                {13, 16}, {15, 16}, {15, 17}, {17, 18}
        };
        for (int[] index : grayHexagonsIndices) {
            colorHexagon(index[0], index[1], GRAY);
        }
//------------------------------------------------------------
        Color BLUE = Color.rgb(0, 0, 205);
        int[][] blueHexagonsIndices = {
                {5, 6}, {5, 13}, {6, 6}, {6, 7}, {6, 14}, {7, 14}, {7, 5}, {7, 6}, {7, 7},
                {8, 5}, {8, 15}, {8, 16}, {8, 6}, {8, 7}, {9, 14}, {9, 15}, {9, 16}, {9, 17},
                {9, 18}, {10, 15}, {11, 14}, {12, 14}, {13, 14}, {14, 14}, {15, 13}, {16, 13},
                {10, 5}, {11, 5}, {12, 5}, {13, 4}, {14, 4}, {15, 3}, {16, 4}, {17, 3}, {18, 4}, {19, 4}
        };

        for (int[] index : blueHexagonsIndices) {
            colorHexagon(index[0], index[1], BLUE);
        }
//------------------------------------------------------------
        Color YELLOW = Color.rgb(255,255, 0);
        int[][] yellowHexagonsIndices = {
                {0, 0}, {0, 10}, {0, 11}, {1, 10}, {2, 10}, {2, 11}, {0, 1}, {1, 0}, {3, 5}, {3, 6},
                {4, 6}, {4, 7}, {5, 7}, {6, 18}, {5, 18}, {7, 16}, {7, 17}, {7, 19}, {8, 17}, {8, 18},
                {8, 19}, {9, 19}, {5, 7}, {5, 8}, {6, 8}, {6, 9}, {7, 8}, {8, 11}, {8, 14}, {9, 10},
                {9, 11}, {9, 12}, {9, 13}, {10, 3}, {10, 4}, {10, 6}, {10, 7}, {10, 8}, {10, 9}, {11, 3},
                {11, 6}, {11, 7}, {11, 8}, {11, 9}, {12, 6}, {12, 7}, {13, 6}, {11, 4}, {18, 11}, {19, 11},
                {19, 12}, {13, 18}, {13, 19}, {14, 16}, {14, 17}, {14, 18}, {14, 19}, {15, 18}, {15, 19},
                {16, 16}, {16, 17}, {16, 18}
        };

        for (int[] index : yellowHexagonsIndices) {
            colorHexagon(index[0], index[1], YELLOW);
        }
//------------------------------------------------------------
        Color BROWN = Color.rgb(139, 69, 19);
        int[][] brownHexagonsIndices = {
                {0, 2}, {0, 12}, {0, 13}, {0, 14}, {1, 11}, {1, 12}, {2, 12}, {3, 11}, {3, 10}, {1, 2},
                {2, 0}, {2, 1}, {2, 2}, {2, 7}, {3, 0}, {3, 2}, {3, 7}, {3, 8}, {3, 1}, {4, 0}, {4, 8},
                {5, 16}, {5, 19}, {5, 17}, {6, 16}, {6, 17}, {6, 19}, {7, 18}, {6, 12}, {7, 12}, {8, 12},
                {4, 9}, {8, 8}, {8, 9}, {8, 10}, {8, 12}, {9, 7}, {9, 8}, {9, 9}, {5, 9}, {10, 0}, {10, 1},
                {10, 2}, {11, 2}, {12, 2}, {13, 1}, {14, 1}, {14, 10}, {15, 10}, {15, 11}, {16, 10},
                {16, 11}, {16, 12}, {17, 10}, {17, 11}, {14, 0}, {15, 0}, {16, 0}, {16, 19}, {17, 17},
                {17, 19}, {18, 17}, {18, 18}, {18, 19}, {19, 17}, {19, 18}, {19, 19}
        };
        for (int[] index : brownHexagonsIndices) {
            colorHexagon(index[0], index[1], BROWN);
        }
//-----------------------------------------------------------
        Color GREEN = Color.rgb(0, 80, 0);
        int[][] greenHexagonsIndices = {
                {0, 3}, {0, 15}, {0, 16}, {1, 15}, {1, 16}, {1, 17}, {2, 15}, {2, 16}, {3, 15}, {5, 11},
                {5, 12}, {6, 11}, {6, 13}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {1, 3}, {1, 4}, {1, 5}, {1, 6},
                {2, 6}, {6, 3}, {7, 2}, {7, 3}, {8, 2}, {8, 3}, {9, 0}, {9, 1}, {9, 2}, {10, 12}, {10, 13},
                {10, 14}, {11, 12}, {11, 13}, {12, 13}, {13, 12}, {13, 13}, {14, 13}, {14, 2}, {14, 3},
                {14, 7}, {15, 12}, {15, 4}, {15, 5}, {15, 6}, {15, 1}, {15, 2}, {16, 2}, {16, 3}, {17, 2},
                {17, 9}, {18, 9}, {18, 10}, {19, 8}, {19, 9}, {19, 10}, {18, 2}, {18, 3}, {19, 2}, {19, 3},
                {19, 13}, {19, 14}, {19, 15}, {19, 16}, {18, 16}, {10, 17}, {10, 18}, {11, 16}, {11, 16},
                {11, 17}
        };

        for (int[] index : greenHexagonsIndices) {
            colorHexagon(index[0], index[1], GREEN);
        }
//---------------------------------------------------------
        Color PINK = Color.rgb(255,20,147);
        int[][] pinkHexagonsIndices = {
                {2, 8}, {1, 13}, {1, 14}, {2, 13}, {2, 14}, {3, 13}, {2, 9}, {2, 18}, {3, 16}, {3, 17},
                {3, 18}, {3, 19}, {4, 18}, {4, 19}, {2, 3}, {2, 4}, {2, 5}, {3, 2}, {3, 3}, {3, 9},
                {3, 4}, {4, 3}, {4, 4}, {4, 5}, {5, 3}, {5, 4}, {5, 5}, {6, 4}, {6, 5}, {7, 13}, {8, 13},
                {11, 11}, {12, 9}, {12, 11}, {12, 12}, {13, 7}, {13, 8}, {13, 9}, {13, 10}, {13, 11},
                {14, 8}, {14, 9}, {14, 11}, {15, 8}, {15, 9}, {16, 5}, {16, 6}, {16, 7}, {16, 8}, {16, 9},
                {17, 7}, {16, 14}, {17, 14}, {17, 15}, {18, 14}, {10, 19}, {11, 18}, {11, 19}, {12, 17},
                {12, 18}, {12, 19}, {13, 17}
        };

        for (int[] index : pinkHexagonsIndices) {
            colorHexagon(index[0], index[1], PINK);
        }

//---------------------------------------------------------
        Color GRASS = Color.rgb(0,200,0);
        int[][] grassHexagonsIndices = {
                {0, 8}, {0, 17}, {0, 18}, {0, 19}, {1, 18}, {1, 19}, {2, 19}, {0, 9}, {1, 8}, {3, 12},
                {3, 14}, {4, 10}, {4, 11}, {4, 12}, {4, 13}, {4, 14}, {4, 15}, {4, 16}, {4, 17}, {5, 10},
                {5, 14}, {5, 15}, {6, 10}, {6, 15}, {7, 9}, {7, 10}, {1, 9}, {4, 1}, {4, 2}, {5, 0},
                {5, 1}, {6, 1}, {6, 2}, {6, 0}, {7, 0}, {8, 0}, {8, 4}, {9, 3}, {9, 4}, {9, 5}, {9, 6},
                {7, 1}, {10, 10}, {10, 11}, {11, 10}, {12, 10}, {17, 0}, {17, 4}, {17, 6}, {17, 8},
                {17, 1}, {18, 5}, {18, 6}, {18, 7}, {18, 8}, {19, 5}, {18, 0}, {18, 1}, {19, 0}, {19, 6},
                {19, 7}, {19, 1}, {10, 16}, {11, 15}, {12, 15}, {12, 16}, {13, 15}, {14, 15}, {15, 14},
                {15, 15}, {16, 15}, {17, 12}, {17, 13}, {18, 13}
        };

        for (int[] index : grassHexagonsIndices) {
            colorHexagon(index[0], index[1], GRASS);
        }
        //----------------------------------------------
        Color BLACK = Color.rgb(0, 0, 0);
        int[][] Silber_BurgHexagonsIndices = {
                {1, 1}, {7, 11}, {14, 12}, {17,5}
        };

        for (int[] index : Silber_BurgHexagonsIndices) {
            colorHexagon(index[0], index[1], BLACK);
        }
        //--------------------------------------------------
        Color DARK_BLUE = Color.rgb(0, 255, 255);
        int[][] Gold_Burg_HexagonsIndices = {
                 {1, 7}, {2, 17}, {5, 2}, {12, 8}, {16, 1}, {18, 12}, {17, 16}, {7,15}
        };

        for (int[] index : Gold_Burg_HexagonsIndices) {
            colorHexagon(index[0], index[1], DARK_BLUE);
        }
        // Create an Icon Silver Burg
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Silver_Castle.jpg")));
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(54);
        imageView.setFitWidth(54);
        Rectangle clip = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip.setArcWidth(40);
        clip.setArcHeight(40);
        imageView.setClip(clip);
        imageView.setLayoutX(94);
        imageView.setLayoutY(65);
        root.getChildren().add(imageView);
        // Create an Icon Silver Burg
        Image image1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Gold_Castle.jpg")));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(54);
        imageView1.setFitWidth(54); // can´t share the clip node: Every ImageView should have a clip
        Rectangle clip1 = new Rectangle(imageView.getFitWidth(), imageView.getFitHeight());
        clip1.setArcWidth(40);
        clip1.setArcHeight(40);
        imageView1.setClip(clip1);
        imageView1.setLayoutX(94 + 50);
        imageView1.setLayoutY(65 + 163);
        root.getChildren().add(imageView1);

        //---------------------------------------------------
        Image FisherImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Fisher.png")));
        ImageView FisherView = new ImageView(FisherImage);
        FisherView.setFitHeight(280);
        FisherView.setFitWidth(130);
        FisherView.setX(1040);
        FisherView.setY(25);
        root.getChildren().add(FisherView);
       //-------------------------------------------------
        Image KnightsImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Knights.png")));
        ImageView KnightsView = new ImageView(KnightsImage);
        KnightsView.setFitHeight(280);
        KnightsView.setFitWidth(130);
        KnightsView.setX(1040+350);
        KnightsView.setY(25);
        root.getChildren().add(KnightsView);
        //-------------------------------------------
        Image MerchantsImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Merchants.png")));
        ImageView MerchantsView = new ImageView(MerchantsImage);
        MerchantsView.setFitHeight(280);
        MerchantsView.setFitWidth(130);
        MerchantsView.setX(1040+ 175);
        MerchantsView.setY(25);
        root.getChildren().add(MerchantsView);

        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Icon.jpg")));
        primaryStage.getIcons().add(icon);
    //---------------------------------------------------- //Add game Avatar
        Image Player1 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Player1_Avatar.png")));
        ImageView Player1Views = new ImageView(Player1);
        Player1Views.setFitHeight(280);
        Player1Views.setFitWidth(210);
        Player1Views.setX(1040);
        Player1Views.setY(550);
        root.getChildren().add(Player1Views);

        Image Player2 = new Image(Objects.requireNonNull(getClass().getResourceAsStream("Player2_Avatar.png")));
        ImageView Player2Views = new ImageView(Player2);
        Player2Views.setFitHeight(280);
        Player2Views.setFitWidth(210);
        Player2Views.setX(1040+250);
        Player2Views.setY(550);
        root.getChildren().add(Player2Views);

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setTitle("Hexagonal Board");
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    private Polygon createHexagon(double centerX, double centerY, double size) {// Form the hexa
        Polygon hexagon = new Polygon();
        for (int i = 0; i < 6; i++) {
            double angle_deg = 60 * i - 30;
            double angle_rad = Math.toRadians(angle_deg);
            double x = centerX + size * Math.cos(angle_rad);
            double y = centerY + size * Math.sin(angle_rad);
            hexagon.getPoints().addAll(x, y);
        }
        hexagon.setFill(Color.WHITE);
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
