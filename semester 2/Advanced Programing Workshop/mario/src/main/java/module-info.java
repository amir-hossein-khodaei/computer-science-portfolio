module com.example.mario {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mario to javafx.fxml;
    exports com.example.mario;
}