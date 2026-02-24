package com.example.demo11;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;

public class HelloController {
    @FXML
    Pane pane ;
    @FXML
    ComboBox combo ;
    @FXML
    Spinner spaner ;
    @FXML
    TableView miz ;
    @FXML
    TableColumn fjname , ljname , jemail , jage , jgender ;
    @FXML
    TextField fname , lname , email , passmail ;

    ObservableList<Map<String,Object>> tableitems=FXCollections.observableArrayList();
    public void initialize(){
        spaner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5 , 100 , 18 ));

        ObservableList<String> fehrest= FXCollections.observableArrayList() ;
        fehrest.add("female");
        fehrest.add("male");
        combo.setItems(fehrest);

        fjname.setCellValueFactory(new MapValueFactory<>("firstname"));
        ljname.setCellValueFactory(new MapValueFactory<>("lastname"));
        jemail.setCellValueFactory(new MapValueFactory<>("email"));
        jage.setCellValueFactory(new MapValueFactory<>("age"));
        jgender.setCellValueFactory(new MapValueFactory<>("gender"));


        Map<String, Object> row1 = new HashMap<>();
        row1.put("firstname", fname.getText());
        row1.put("lastname", lname.getText());
        row1.put("email", email.getText());
        row1.put("age", spaner.getValue());
        row1.put("gender", combo.getValue());
        tableitems.add(row1);
        miz.setItems(tableitems);


    }
}