module com.example.is {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.is.Vidmot to javafx.fxml;

    exports com.example.is.Vidmot;
}
