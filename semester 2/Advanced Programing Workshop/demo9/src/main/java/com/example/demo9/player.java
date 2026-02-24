package com.example.demo9;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.io.File;

public class player {
    private ImageView imageView ;
    private Pane pane ;

    public player(int x , int y , int width , int height , Image image , Pane pane  )
    {
        this.pane = pane ;
        imageView = new ImageView(image);
        imageView.setX(x);
        imageView.setY(y);
        imageView.setFitWidth(width);
        imageView.setFitHeight(height);
    }
    public void addtopane(){
        pane.getChildren().add(imageView);
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

}
