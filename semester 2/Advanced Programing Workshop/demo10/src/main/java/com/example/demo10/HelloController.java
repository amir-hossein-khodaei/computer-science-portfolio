package com.example.demo10;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;

public class HelloController {
    @FXML
    Pane pane;

    ArrayList<enemy> enemysArrayList = new ArrayList<enemy>();
    private com.example.demo9.player player;

    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("images/222.png"));
        player = new com.example.demo9.player(100, 250, 150, 120, image, pane);
        player.addtopane();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4000), actionEvent -> {
            enemy enemy = new enemy(800, 250, 100, 150, image, pane);
            enemy.addtopane();
            enemy.move();
            enemysArrayList.add(enemy);

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(50), actionEvent -> {
            enemy enemy = new enemy(800, 250, 100, 150, image, pane);
            pane.requestFocus();
   //         checkConflict();

        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();



//        pane.setOnKeyPressed(keyEvent -> {
//
//            if (keyEvent.getCode() == KeyCode.SPACE) {
//
//                final Timeline timeline3 = new Timeline();
//                timeline3.setCycleCount(2);
//                timeline3.setAutoReverse(true);
//                final KeyValue kv1 = new KeyValue(imageView.yProperty(), 300); //speed!! up
//                final KeyFrame kf1 = new KeyFrame(Duration.millis(500), kv1); //speed!! down
//                timeline3.getKeyFrames().add(kf1);
//                timeline3.play();
//
//            } else if (keyEvent.getCode() == KeyCode.A) {
//                imageView.setX(imageView.getX() - 10);
//            } else if (keyEvent.getCode() == KeyCode.D) {
//                imageView.setX(imageView.getX() + 10);
//            }
//        });
//    }
//    private void checkConflict() {
//        for (enemy x : enemysArrayList) {
//            if (x.getImageView().intersects(player.getImageView().getBoundsInParent())) {
//                x.removefromepane();
//                enemysArrayList.remove(x);
//                System.out.println("dd");
//                break;
//            }
//        }
//    }
}