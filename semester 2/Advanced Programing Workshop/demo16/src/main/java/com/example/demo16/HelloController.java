package com.example.demo16;

import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


import java.awt.*;

public class HelloController {
    int max ;
    int counter = 0 ;
    @FXML
    Button Button ;
@FXML

Spinner Spinner ;
@FXML
    Pane Pane ;
    @FXML
    protected void initialize(){
Spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 99 , 1 ,1 ));

        Color[] allcolor = {Color.BLUE,Color.PINK,Color.gray,Color.green,Color.lightGray,Color.darkGray,Color.magenta,Color.red,Color.darkGray,Color.cyan,Color.orange};
        Button.setOnMouseClicked(event -> {
            max= (int) Spinner.getValue();
        });
        Pane.setOnMouseClicked(event -> {
            if (counter < max) {
                counter++;
                String color = "#" + ((int) (Math.random() * 1000000 + 100000));
                Circle circle = new Circle(event.getX(),event.getY(), Math.random() * 200); //x , y , r
                circle.setFill(new javafx.scene.paint.Color( (float) Math.random(),(float) Math.random(),(float) Math.random(),(float) Math.random()));
                ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), circle);
                Timeline timeline2 = new Timeline(new KeyFrame(Duration.millis(20),actionEvent -> {
                    circle.setFill(new javafx.scene.paint.Color( (float) Math.random(),(float) Math.random(),(float) Math.random(),(float) Math.random()));
                }));
                scaleTransition.setToX(0);
                scaleTransition.setToY(0);
                scaleTransition.setCycleCount(1);
                scaleTransition.setAutoReverse(false);
                ParallelTransition parallelTransition = new ParallelTransition();//combine shapes
                parallelTransition.getChildren().addAll(scaleTransition);
                parallelTransition.setCycleCount(Timeline.INDEFINITE);
                parallelTransition.play();
                Pane.getChildren().add(circle);
                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(2000),actionEvent -> {
                    Pane.getChildren().remove(circle);
                }));
                timeline.setCycleCount(-1);
                timeline.play();
                timeline2.setCycleCount(-1);
                timeline2.play();
            }else {
                System.out.println("error");
            }
        });
    }
}