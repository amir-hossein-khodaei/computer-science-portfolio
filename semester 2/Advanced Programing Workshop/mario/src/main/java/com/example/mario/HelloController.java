package com.example.mario;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class HelloController {
    @FXML
    Pane pane ;
    @FXML
    public void initialize(){
        Image wallpaper = new Image(getClass().getResourceAsStream("images/wallpaper.jpg"));
        BackgroundImage backgroundImage=new BackgroundImage(wallpaper, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);

        Image image = new Image(getClass().getResourceAsStream("images/222.png"));
        ImageView imageView = new ImageView(image);
        imageView.setX(10);
        imageView.setY(526);
        imageView.setFitHeight(92);
        imageView.setFitWidth(74);
        pane.getChildren().add(imageView);

        Timeline timeline = new Timeline();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                pane.requestFocus();
            }
        }) ;
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();

        pane.setOnKeyPressed(keyEvent -> {

             if (keyEvent.getCode() == KeyCode.SPACE) {

                final Timeline timeline1 = new Timeline();
                timeline1.setCycleCount(2);
                timeline1.setAutoReverse(true);
                final KeyValue kv1 = new KeyValue(imageView.yProperty(), 300); //speed!! up
                final KeyFrame kf1 = new KeyFrame(Duration.millis(500), kv1); //speed!! down
                timeline1.getKeyFrames().add(kf1);
                timeline1.play();
                
            }

            else if(keyEvent.getCode()== KeyCode.A){
                imageView.setX(imageView.getX()-10);
            }

            else if(keyEvent.getCode()== KeyCode.D){
                imageView.setX(imageView.getX()+10);
            }
        });

    }
}