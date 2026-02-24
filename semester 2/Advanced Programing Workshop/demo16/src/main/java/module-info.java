module com.example.demo16 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires jdk.xml.dom;

    opens com.example.demo16 to javafx.fxml;
    exports com.example.demo16;
}