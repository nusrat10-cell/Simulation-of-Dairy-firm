module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.dairy to javafx.fxml;
    exports com.example.dairy;
}