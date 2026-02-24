package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
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

    public void initialize(){
        spaner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(5 , 100 , 18 ));

        ObservableList<String>fehrest= FXCollections.observableArrayList() ;
        fehrest.add("female");
        fehrest.add("male");
        combo.setItems(fehrest);
    }
    ObservableList<Map<String,Object>> tableitems=FXCollections.observableArrayList();
    public void dockme() throws IOException {
        String check1 = "1233456789" ;
        String check = "QWERTYUIOPASDFGHJKLZXCVBNM.";
        String check2 = "qwertyuiopasdfghjklzxcvbnm";
        boolean checker = false ;
        boolean checker1 = false ;
        boolean checker2 = false ;
        boolean checker3 = false ;
        boolean checker4 = false ;
        boolean checker5 = false ;


        fjname.setCellValueFactory(new MapValueFactory<>("firstname"));
        ljname.setCellValueFactory(new MapValueFactory<>("lastname"));
        jemail.setCellValueFactory(new MapValueFactory<>("email"));
        jage.setCellValueFactory(new MapValueFactory<>("age"));
        jgender.setCellValueFactory(new MapValueFactory<>("gender"));


        for (int i=0 ; i < check.length() ; i ++ ) {
            if(fname.getText().charAt(0) == check.charAt(i)){
                checker = true;
            }
        }

        for (int i=0 ; i < check.length() ; i ++ ) {
            if(lname.getText().charAt(0) == check.charAt(i)){
                checker1 = true;
            }
        }
        if (passmail.getText().length()>=8){
            checker4 = true ;
        }

        for (int i = 0 ; i < passmail.getLength() ; i++){
            for (int j = 0 ; j < check.length() ; j++){
                if(passmail.getText().charAt(i) == check.charAt(j)){
                    checker2 = true;
                }
            }
        }
        for (int i = 0 ; i < passmail.getLength() ; i++){
            for (int j = 0 ; j < check2.length() ; j++){
                if(passmail.getText().charAt(i) == check2.charAt(j)){
                    checker3 = true;
                }
            }
        }
        for (int i = 0 ; i < passmail.getLength() ; i++){
            for (int j = 0 ; j < check1.length() ; j++){
                if(passmail.getText().charAt(i) == check1.charAt(j)){
                    checker5 = true;
                }
            }
        }






            if (checker && checker1 && (email.getText().contains("@")) && (email.getText().contains(".")) && checker4 && checker2 && checker3 && checker5  ) {
                Map<String, Object> row1 = new HashMap<>();
                row1.put("firstname", fname.getText());
                row1.put("lastname", lname.getText());
                row1.put("email", email.getText());
                row1.put("age", spaner.getValue());
                row1.put("gender", combo.getValue());
                tableitems.add(row1);
                miz.setItems(tableitems);
            }
            else {
                System.out.println("error");
            }


    }
}