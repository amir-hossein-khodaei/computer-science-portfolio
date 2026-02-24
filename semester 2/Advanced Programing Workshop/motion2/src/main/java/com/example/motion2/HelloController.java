package com.example.motion2;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class HelloController {
    @FXML
    Pane pan ;

    @FXML
    protected void onHelloButtonClick() {

//
//        //aghab jelo
//
//        final Rectangle rectBasicTimeline1 = new Rectangle(100, 50, 100, 50);
//        rectBasicTimeline1.setFill(Color.BLUE);
//        pan.getChildren().add(rectBasicTimeline1);
//        final Timeline timeline1 = new Timeline();
//        timeline1.setCycleCount(Timeline.INDEFINITE);
//        timeline1.setAutoReverse(true);
//        final KeyValue kv1 = new KeyValue(rectBasicTimeline1.xProperty(), 300); //speed!! up
//        final KeyFrame kf1 = new KeyFrame(Duration.millis(500), kv1); //speed!! down
//        timeline1.getKeyFrames().add(kf1);
//        timeline1.play();}}
//
//
//
////sinosssssss
//        final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
//        rectPath.setArcHeight(10);
//        rectPath.setArcWidth(10);
//        rectPath.setFill(Color.ORANGE);
//        pan.getChildren().add(rectPath);
//        Path path = new Path();
//        path.getElements().add(new MoveTo(20,20));
//        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120)); //baze baze payan
//        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//        PathTransition pathTransition = new PathTransition();
//        pathTransition.setDuration(Duration.millis(4000));
//        pathTransition.setPath(path);
//        pathTransition.setNode(rectPath);
//        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
//        pathTransition.play();
//
//
////        fade
//        final Rectangle rect1 = new Rectangle(10, 10, 100, 100);
//        rect1.setArcHeight(20); // rectangle goshe
//        rect1.setArcWidth(20);
//        rect1.setFill(Color.PALEGOLDENROD);
//        pan.getChildren().add(rect1);
//        FadeTransition ft = new FadeTransition(Duration.millis(3000), rect1);
//        ft.setFromValue(1.0);
//        ft.setToValue(0.0); // meghdar penhan shodan
//        ft.setCycleCount(Timeline.INDEFINITE);
//        ft.setAutoReverse(true);
//        ft.play();
//

        Rectangle rectParallel = new Rectangle(10,200,50, 50);
        rectParallel.setArcHeight(15);
        rectParallel.setArcWidth(15);
        rectParallel.setFill(Color.DARKBLUE);
        rectParallel.setTranslateX(200);//mogheita shoroi
        rectParallel.setTranslateY(200);
        pan.getChildren().add(rectParallel);
        FadeTransition fadeTransition = new FadeTransition(Duration.millis(3000), rectParallel);
        fadeTransition.setFromValue(1.0f);
        fadeTransition.setToValue(0.3f);
        fadeTransition.setCycleCount(2);
        fadeTransition.setAutoReverse(true);
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(2000), rectParallel);
        translateTransition.setFromX(50);
        translateTransition.setToX(350);
        translateTransition.setCycleCount(2);
        translateTransition.setAutoReverse(true);
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(3000), rectParallel);
        rotateTransition.setByAngle(180f);
        rotateTransition.setCycleCount(4);
        rotateTransition.setAutoReverse(true);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(2000), rectParallel);
        scaleTransition.setToX(2f);
        scaleTransition.setToY(2f);
        scaleTransition.setCycleCount(2);
        scaleTransition.setAutoReverse(true);

        ParallelTransition parallelTransition = new ParallelTransition();//combine shapes
        parallelTransition.getChildren().addAll(fadeTransition, translateTransition, rotateTransition, scaleTransition);
        parallelTransition.setCycleCount(Timeline.INDEFINITE);
        parallelTransition.play();

    }
}