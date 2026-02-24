package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
Pane pane;
Button btn;
    @FXML
    protected void draw() {
        for (int i = 0 ; i<=200;i +=5){
            pane.getChildren().add(new Line(i,200,200,200-i));
            pane.getChildren().add(new Line(200,400-i,200+i,200));
            pane.getChildren().add(new Line(200,i,200+i,200));
            pane.getChildren().add(new Line(i,200,200,200+i));
        }
    }
}