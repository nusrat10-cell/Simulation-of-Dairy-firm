module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.dairy to javafx.fxml;
    exports com.example.dairy;
    exports com.example.dairy.mahamud;
    opens com.example.dairy.mahamud to javafx.fxml;
}