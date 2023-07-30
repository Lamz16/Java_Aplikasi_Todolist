module com.example.javavol2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javavol2 to javafx.fxml;
    exports com.example.javavol2;
}