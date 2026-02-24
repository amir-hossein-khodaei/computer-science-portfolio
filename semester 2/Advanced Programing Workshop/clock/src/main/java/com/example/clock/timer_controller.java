package com.example.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.time.LocalTime;
import java.util.Locale;

public class timer_controller {
    @FXML
    Pane timer_pane ;

    private int h , m , s ;

    public void initialize(){

        Timeline timeline = new Timeline(new KeyFrame(new Duration(1000) , actionEvent -> {

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public timer_controller(int h , int m , int s ){
        this.h=h;
        this.m=m;
        this.s=s;

    }
}
