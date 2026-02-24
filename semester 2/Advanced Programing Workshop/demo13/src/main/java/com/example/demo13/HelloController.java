package com.example.demo13;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HelloController {
    @FXML
    Pane pane ;
    @FXML
    TextField f_name ,l_name , e_mail , P_assword ;
    @FXML
    Spinner age ;
    @FXML
    Button button , show ;
    List<table> temp = new ArrayList<>();
    @FXML
    public void initialize(){
        f_name.getText();
        age.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1 , 99 , 1 ,1 ));
        l_name.getText();
        e_mail.getText();
        P_assword.getText();


        show.setOnAction(actionEvent -> {

            Stage stage = new Stage() ;
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("table.fxml"));


            Scanner scanner = null;
            try {
                scanner = new Scanner(new File("txt.text"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            while(scanner.hasNextLine()){
                String f = scanner.nextLine();
                String l = scanner.nextLine();
                String e = scanner.nextLine();
                String p = scanner.nextLine();
                String a = scanner.nextLine();
                temp.add(new table(f, l , e , p , a ));
            }
            fxmlLoader.setController(new table(temp));


            Scene scene = null;
            try {
                scene = new Scene(fxmlLoader.load(), 1080, 720);
            } catch (IOException b) {
                throw new RuntimeException(b);
            }
            stage.setTitle("table");
            stage.setScene(scene);

            stage.show();

        });
        button.setOnAction(actionEvent -> {
            FileWriter pw = null;
            try {
                pw = new FileWriter("txt.text" , true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.write(f_name.getText()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.write(l_name.getText()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.write(e_mail.getText()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.write(P_assword.getText()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.write(age.getValue().toString()+"\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        });
    }
}