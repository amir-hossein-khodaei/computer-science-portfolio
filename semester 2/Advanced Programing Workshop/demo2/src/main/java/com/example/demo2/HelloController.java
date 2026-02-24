package com.example.demo2;

import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private Pane pane ;

    @FXML

    public void initialize(){


        Rectangle rectParallel = new Rectangle(10,200,50, 50);
        pane.getChildren().add(rectParallel);

        RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectParallel);
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(Timeline.INDEFINITE);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().addAll(rotateTransition);
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();


        pane.setOnMouseMoved(event -> {
            rectParallel.setX(event.getX());
            rectParallel.setY(event.getY());

        });

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.requestFocus();
            }
        }) ;
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        Circle circle = new Circle(200, 200 ,50  , Color.color(0.5,0.8,0.6) );
        pane.getChildren().add(circle);
        pane.setOnKeyPressed(keyEvent -> {
                if(keyEvent.getCode()== KeyCode.W){
                    circle.setCenterY(circle.getCenterY()-5);
                }
                if(keyEvent.getCode()== KeyCode.S){
                    circle.setCenterY(circle.getCenterY()+5);
                }
                if(keyEvent.getCode()== KeyCode.A){
                    circle.setCenterX(circle.getCenterX()-5);
                }
                if(keyEvent.getCode()== KeyCode.D){
                    circle.setCenterX(circle.getCenterX()+5);
                }
            } );
    }
}