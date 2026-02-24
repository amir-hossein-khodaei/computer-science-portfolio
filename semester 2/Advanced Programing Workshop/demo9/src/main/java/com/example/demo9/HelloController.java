package com.example.demo9;

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
    Pane backgroundPane = new Pane();
    Pane upergroundPane = new Pane();
    @FXML
    Pane pane;

    ArrayList<enemy> enemysArrayList = new ArrayList<enemy>();
    private player player;
    private int counter = 0 ;
    @FXML
    public void initialize(){
        Image image = new Image(getClass().getResourceAsStream("images/222.png"));
        player = new player(100,250,150,120,image,pane);
        player.addtopane();

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400), actionEvent -> {
            enemy enemy = new enemy((int) (Math.random()*1080),(int)(Math.random()*500),100,150, image , backgroundPane);
            enemy.addtopane();
            enemy.move();
            enemysArrayList.add(enemy);

        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


        Timeline timeline1 = new Timeline(new KeyFrame(Duration.millis(50), actionEvent -> {
            enemy enemy = new enemy(800,250,100,150, image , upergroundPane);
            pane.requestFocus();
            checkConflict();

        }));
        timeline1.setCycleCount(Timeline.INDEFINITE);
        timeline1.play();

        pane.getChildren().addAll(upergroundPane,backgroundPane);

        pane.setOnKeyPressed(keyEvent -> {

            if (keyEvent.getCode() == KeyCode.SPACE) {
                final Timeline timeline3 = new Timeline();
                timeline3.setCycleCount(1);
                timeline3.setAutoReverse(true);
                final KeyValue kv1 = new KeyValue(player.getImageView().yProperty(), -100); //speed!! up
                final KeyFrame kf1 = new KeyFrame(Duration.millis(500), kv1); //speed!! down
                timeline3.getKeyFrames().add(kf1);
                timeline3.play();
                final Timeline timeline4 = new Timeline();
                timeline4.setCycleCount(1);
                timeline4.setAutoReverse(true);
                final KeyValue kv2 = new KeyValue(player.getImageView().yProperty(), -100); //speed!! up
                final KeyFrame kf2 = new KeyFrame(Duration.millis(500), kv2); //speed!! down
                timeline4.getKeyFrames().add(kf2);
                timeline3.setOnFinished(actionEvent -> {
                    timeline4.play();
                });

            }
            else if(keyEvent.getCode()== KeyCode.A){
                player.setx(player.getx()-10);
            }
            else if(keyEvent.getCode()== KeyCode.D){
                player.setx(player.getx()+10);
            }
        });
    }



    private void checkConflict() {
        for(enemy x : enemysArrayList){
            if (x.getImageView().intersects(player.getImageView().getBoundsInParent())){
                x.removefromepane();
                System.out.println(counter);
                enemysArrayList.remove(x);
                break;
            }
        }
    }
}