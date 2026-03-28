module com.example {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example to javafx.fxml;
    exports com.example;
}