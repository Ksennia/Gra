package com.kodilla;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.BitSet;
import java.util.HashSet;
import java.util.Random;


public class TicTacToe extends Application {

    private Image imageback = new Image("/file/tictacplant.png");
    private Image iks = new Image("/file/x.png");
    private Image circle = new Image("/file/circle.png");
    private FlowPane turn = new FlowPane(Orientation.HORIZONTAL);
    private boolean isComputerTurn = true;
    ImageView show = new ImageView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // plansza
        BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(imageback, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        //colums & rows on the scene
        GridPane grid = new GridPane();
        grid.setBackground(background);

        //colums
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setPercentWidth(35);
        grid.getColumnConstraints().add(column1);

        ColumnConstraints column2 = new ColumnConstraints();
        column2.setPercentWidth(30);
        grid.getColumnConstraints().add(column2);

        ColumnConstraints column3 = new ColumnConstraints();
        column3.setPercentWidth(35);
        grid.getColumnConstraints().add(column3);

        //rows
        RowConstraints row1 = new RowConstraints();
        row1.setPercentHeight(35);
        grid.getRowConstraints().add(row1);

        RowConstraints row2 = new RowConstraints();
        row2.setPercentHeight(30);
        grid.getRowConstraints().add(row2);

        RowConstraints row3 = new RowConstraints();
        row3.setPercentHeight(35);
        grid.getRowConstraints().add(row3);
        // grid.add(figure,1 ,1);
        Scene scene = new Scene(grid, 920, 765, Color.YELLOW);


        //ekran
        grid.setGridLinesVisible(true);
        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();


        // set 8 pictures type and size yes, i need so much

        int crossIndex ;
        ImageView[] cross = new ImageView[9];
        for ( crossIndex = 0; crossIndex < 9; crossIndex++ ) {

            cross[crossIndex] = new ImageView();
            cross[crossIndex].setImage(iks);
            cross[crossIndex].setFitWidth(150);
            cross[crossIndex].setPreserveRatio(true);
            cross[crossIndex].setSmooth(true);
            cross[crossIndex].setCache(true);

            System.out.println(crossIndex+1);        }

        int cirkleIndex = 9;
        ImageView[] o = new ImageView[cirkleIndex];
        for ( cirkleIndex = 0; cirkleIndex < 9; cirkleIndex++ ) {

            o[cirkleIndex] = new ImageView();
            o[cirkleIndex].setImage(circle);
            o[cirkleIndex].setFitWidth(150);
            o[cirkleIndex].setPreserveRatio(true);
            o[cirkleIndex].setSmooth(true);
            o[cirkleIndex].setCache(true);
        }

        int k = 9;
        //
        // logic operations
        //
        int[] logic = new int[k];
        //
        // button add
        //


        Button[] button = new Button[k];

        for ( k = 0; k < 9; k++) {
            System.out.println("Guzik " + (k + 1));


            button[k] = new Button();
            button[k].setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            button[k].setBackground(Background.EMPTY);


            int finalCrossIndex = k;
            int finalCirkleIndex = k;
            int finalK = k;
            int finalK1 = k;
            button[k].setOnMouseClicked(e -> {
                if ( isComputerTurn ) {
                    button[finalK].setGraphic(cross[finalCrossIndex]);
                    logic[finalK1] = 1;
                    System.out.println("Dajesz krzyż " + (finalCrossIndex +1));
                } else {
                    button[finalK].setGraphic(o[finalCirkleIndex]);
                    logic[finalK1] = 2;
                    System.out.println("dajesz kólko" + (finalCirkleIndex + 1));
                }
                isComputerTurn = !isComputerTurn;

            });
            logic[k] = logic[finalK1];
            System.out.println(logic[k]);
        }

        //
        // give the place
        //
        int m = 0;
        for (int i = 0; i < 3; i++ ) {
            for ( int j = 0; j <3; j++ ) {

                 if ( i == 0) {
                     m = j;
                     grid.add(button[m], i, j);
                 } else if ( i == 1) {
                     m = (j + 3);
                     grid.add(button[m], i, j);
                 } else if ( i == 2) {
                     m = (j + 6);
                     grid.add(button[m], i, j);
                 }
            }
        }


        //
        //logika
        //
        //int sum = (logic[0] + logic[1] + logic[2]);
        System.out.println("suma " + logic[0]);
        /*if (((logic[0] + logic[1] + logic[2]) == 6)   || ((logic[0] + logic[3] + logic[6]) == 6) || ((logic[0] + logic[4] + logic[8]) == 6)) {
            System.out.println("Wygraleś");
        } else if ( ((logic[4] + logic[1] + logic[7]) == 6)  || ((logic[4] + logic[3] + logic[5]) == 6) || ((logic[4] + logic[2] + logic[6]) == 6)) {
            System.out.println("Wygraleś");
        } else if (((logic[6] + logic[7] + logic[8]) == 6)  || ((logic[2] + logic[5] + logic[8]) == 6)) {
            System.out.println("Wygraleś");
        }
*/


    }
}
