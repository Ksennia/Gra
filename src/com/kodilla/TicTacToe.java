package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;



public class TicTacToe extends Application {

    private Image imageback = new Image("/file/tictacplant.png");
    private Image iks = new Image("/file/x.png");
    private Image circle = new Image("/file/circle.png");
    //private FlowPane figure = new FlowPane();
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


        // set pictures type and size

        ImageView cross = new ImageView();
        cross.setImage(iks);
        cross.setFitWidth(150);
        cross.setPreserveRatio(true);
        cross.setSmooth(true);
        cross.setCache(true);


        ImageView o = new ImageView();
        o.setImage(circle);
        o.setFitWidth(150);
        o.setPreserveRatio(true);
        o.setSmooth(true);
        o.setCache(true);



        //creature buttons

        for (int i = 0; i < 9; i++) {
            //buttons settings
            Button button = new Button();
            button.setBackground(Background.EMPTY);
            button.setMaxWidth(Double.MAX_VALUE);
            button.setMaxHeight(Double.MAX_VALUE);

            GridPane.setHgrow(button, Priority.ALWAYS);
            GridPane.setVgrow(button, Priority.ALWAYS);


            button.setOnMouseClicked(p -> {
                System.out.println("Click on button");
                button.setGraphic(cross);
                if(isComputerTurn ) {
                    System.out.println("Computer turn");
                } else {
                    System.out.println("Your turn");
                    button.setGraphic(o);
                }
                isComputerTurn = !isComputerTurn;
            });

            //button =  button.getOnMouseClicked();
            if (i == 0)
                grid.add(button, 0, 0);
            if (i == 1)
                grid.add(button, 0, 1);
            if (i == 2)
                grid.add(button, 0, 2);
            if (i == 3)
                grid.add(button, 1, 0);
            if (i == 4)
                grid.add(button, 1, 1);
            if (i == 5)
                grid.add(button, 1, 2);
            if (i == 6)
                grid.add(button, 2, 0);
            if (i == 7)
                grid.add(button, 2, 1);
            if (i == 8)
                grid.add(button, 2, 2);
            //


        }
    }
}