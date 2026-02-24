package com.example.clock;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalTime;

public class HelloController {
    @FXML
    Pane pane ;
    @FXML
    Spinner hours , minuts , seconds ;
    @FXML
    Button timer_button , stopwatch_button ;

    @FXML
    public void initialize(){

        hours.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory());

        timer_button.setOnAction(actionEvent -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("timer_scene.fxml"));
            fxmlLoader.setController(new timer_controller((int) hours.getValue() , (int) minuts.getValue(),(int) seconds.getValue() ));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 480, 480);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("timer");
            stage.setScene(scene);
            stage.show();
        });

        stopwatch_button.setOnAction(actionEvent -> {
            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("stopwatch_scene.fxml"));
            fxmlLoader.setController(new stopwatch_controller((int) hours.getValue() , (int) minuts.getValue(),(int) seconds.getValue() ));
            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 480, 480);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            stage.setTitle("stopwatch");
            stage.setScene(scene);
            stage.show();


            Stage old_stage = (Stage) pane.getScene().getWindow();
            old_stage.close();
        });
    }



}