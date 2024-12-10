module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;

    exports com.example.dairy;
    opens com.example.dairy to javafx.graphics;

    exports com.example.dairy.Nupur;
    opens com.example.dairy.Nupur to javafx.fxml;
}
