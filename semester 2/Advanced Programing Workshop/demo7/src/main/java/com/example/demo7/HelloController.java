package com.example.demo7;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.File;

public class HelloController {
    @FXML
    Pane pane ;

    @FXML
    public void initialize() {

        Image wallpaper = new Image(getClass().getResourceAsStream("images/jase-bloor-oCZHIa1D4EU-unsplash.jpg"));
        BackgroundImage backgroundImage=new BackgroundImage(wallpaper, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        pane.setBackground(background);

        pane.setOnMouseClicked(event -> {

                Timeline timeline = new Timeline(new KeyFrame(Duration.millis(30), e -> {

                    int gol = (int) (Math.random()*10)+2;
                    for (int i = 0 ; i < gol ; i++) {
                        double rand = Math.random();
                        int x_pose = (int) (Math.random() * 1200);

                        Image image = new Image(getClass().getResourceAsStream("images/222.png"));
                        ImageView imageView = new ImageView(image);
                        imageView.setX(x_pose);
                        imageView.setY(0);
                        imageView.setFitHeight(73*rand+36);
                        imageView.setFitWidth(41*rand+20);

                        final Timeline timeline1 = new Timeline();
                        timeline1.setCycleCount(1);
                        timeline1.setAutoReverse(false);
                        final KeyValue kv1 = new KeyValue(imageView.yProperty(), 920 );
                        final KeyValue kv2 = new KeyValue(imageView.xProperty(), x_pose-200 );
                        final KeyFrame kf1 = new KeyFrame(Duration.millis(Math.random()*400+400), kv1 , kv2);
                        timeline1.getKeyFrames().add(kf1);
                        timeline1.play();
                        pane.getChildren().add(imageView);

                        Timeline timeline3 = new Timeline(new KeyFrame(Duration.millis(800), b -> {
                            pane.getChildren().remove(imageView);
                        }));
                        timeline3.setCycleCount(Timeline.INDEFINITE);
                        timeline3.play();
                    }
                    pane.requestFocus();
                }));
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.play();

        });
        pane.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.SPACE) {

                final Rectangle rect1 = new Rectangle(0, 0, 1080, 720);
                rect1.setFill(Color.WHITE);
                pane.getChildren().add(rect1);
                FadeTransition ft = new FadeTransition(Duration.millis(200), rect1);
                ft.setFromValue(1.0);
                ft.setToValue(0.0);
                ft.setCycleCount(3);
                ft.setAutoReverse(false);
                ft.play();

            }
        });
}
}