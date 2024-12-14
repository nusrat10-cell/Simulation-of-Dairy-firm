module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.dairy to javafx.fxml;
    exports com.example.dairy.mahamud;
    opens com.example.dairy.mahamud to javafx.fxml;
    opens com.example.dairy.Samiul.User7 to javafx.fxml, javafx.base;
    opens com.example.dairy.Samiul.User8 to javafx.fxml, javafx.base;

    exports com.example.dairy;


    opens com.example.dairy.ParvezHassan to javafx.fxml, javafx.graphics;
    exports com.example.dairy.ParvezHassan;
}