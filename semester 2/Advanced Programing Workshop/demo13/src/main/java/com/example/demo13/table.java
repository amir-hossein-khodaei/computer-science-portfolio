package com.example.demo13;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class table {

    @FXML
    TableView table ;
    @FXML
    TableColumn a , b , c , d , e ;


    String a1 ,b1 ,c1,d1,e1;
    List<table> temp = new ArrayList<>();

    public table(List<com.example.demo13.table> temp) {
        this.temp =temp ;
    }


//    @FXML
//    public void initialize(){
//        a.setCellValueFactory(new MapValueFactory<>("firstname"));
//        b.setCellValueFactory(new MapValueFactory<>("lastname"));
//        c.setCellValueFactory(new MapValueFactory<>("age"));
//        d.setCellValueFactory(new MapValueFactory<>("email"));
//        e.setCellValueFactory(new MapValueFactory<>("password"));
//
//        for (table j : temp) {
//
//
//            ObservableList<Map<String, Object>> tableitems = FXCollections.observableArrayList();
//
//            Map<String, Object> row1 = new HashMap<>();
//            row1.put("firstname", j.a1);
//            row1.put("lastname", j.b1);
//            row1.put("age", j.c1);
//            row1.put("email", j.d1);
//            row1.put("password", j.e1);
//            tableitems.add(row1);
//            table.setItems(tableitems);
//        }
//
//
//    }

    public table(String text, String text1, String text2, String text3, String value) {
        this.a1=text;
        this.b1=text1;
        this.c1=text2;
        this.d1=text3;
        this.e1=value;


    }
}
