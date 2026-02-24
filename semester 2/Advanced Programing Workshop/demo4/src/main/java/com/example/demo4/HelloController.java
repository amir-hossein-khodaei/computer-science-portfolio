package com.example.demo4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class HelloController {
    @FXML
    private Pane pane ;

    @FXML
    public void initialize (){

        ImageView imageView = new ImageView(new File(HelloController.class.getResource("images/222.png").getFile()).getPath());
        imageView.setX(100);
        imageView.setY(100);
        pane.getChildren().add(imageView);
    }
}