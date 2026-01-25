module com.example.is {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.is.Vidmot to javafx.fxml;
    exports com.example.is.Vidmot;
}