package com.example.demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    TextField tx_name;
    @FXML
    Spinner spiner_y, spiner_x;
    @FXML
    Slider slider_x, slider_y;
    @FXML
    ColorPicker cp_color;
    @FXML
    Button butten;
    @FXML
    Label moraba_text;
    @FXML
    Rectangle morabai;
    @FXML
    Pane plane;


    @FXML
    protected void butten() {
        Rectangle rectangle = new Rectangle();
        rectangle.setX(slider_x.getValue());
        rectangle.setY(slider_y.getValue());
        rectangle.setWidth(slider_x.getValue());
        rectangle.setHeight(slider_y.getValue());
        rectangle.setFill(cp_color.getValue());

        Text text = new Text(tx_name.getText());
        text.setX(rectangle.getX());
        text.setY(rectangle.getY() + rectangle.getHeight() / 2);


        text.xProperty().bind(rectangle.xProperty());
        text.yProperty().bind(rectangle.yProperty().add(rectangle.heightProperty().divide(2)));

        plane.getChildren().addAll(rectangle, text);

        Stage stage = new Stage();

    }
}