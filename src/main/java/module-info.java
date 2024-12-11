//module com.example.dairy {
    //requires javafx.controls;
    //requires javafx.fxml;

    //exports com.example.dairy;
    //exports com.example.dairy.mahamud;

    //opens com.example.dairy to javafx.graphics;
   // opens com.example.dairy.mahamud to javafx.fxml;
//}

module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    exports com.example.dairy;
    exports com.example.dairy.Nupur;

    opens com.example.dairy to javafx.fxml, javafx.graphics;
    opens com.example.dairy.Nupur to javafx.fxml;

    exports com.example.dairy.mahamud;
    opens com.example.dairy.mahamud to javafx.fxml;

    opens com.example.dairy.Samiul.User7 to javafx.fxml;
    opens com.example.dairy.Samiul.User8 to javafx.fxml;

    exports com.example.dairy.ParvezHassan;
    opens com.example.dairy.ParvezHassan to javafx.fxml, javafx.graphics;
}


