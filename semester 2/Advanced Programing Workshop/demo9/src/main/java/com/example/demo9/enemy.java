package com.example.demo9;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class enemy {
    private ImageView imageView ;
    private Pane pane ;

    public enemy(int x , int y , int width , int height , Image image , Pane pane  )
    {
        this.pane = pane ;
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }

    public void addtopane(){
        imageView.setRotationAxis(Rotate.Y_AXIS);
        imageView.setRotate(180);
        pane.getChildren().add(imageView);
    }
    public void removefromepane(){
        pane.getChildren().remove(imageView);
    }
    public double  getx(){
        return imageView.getX();
    }
    public void setx(double x){
        imageView.setX(x);
    }
    public double  gety(){
        return imageView.getY();
    }
    public void sety(double y){
        imageView.setY(y);
    }
    public double  getwidth(){
        return imageView.getFitWidth();
    }
    public void setwidth(double y){
        imageView.setFitWidth(y);
    }
    public double  getheight(){
        return imageView.getFitHeight();
    }
    public void setheight(double y){
        imageView.setFitHeight(y);
    }
    public ImageView getImageView(){
        return imageView ;
    }
    public void setimamgeview(ImageView imageView){
        this.imageView = imageView ;
    }

    public void move() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),actionEvent -> {
            imageView.setX(imageView.getX() - (540-Math.random()*1080));
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
