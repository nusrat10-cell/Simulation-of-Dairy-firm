module com.example.dairy {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;

    // Export the packages to be accessible to javafx.fxml and javafx.graphics
    exports com.example.dairy to javafx.fxml, javafx.graphics;
    exports com.example.dairy.Nupur to javafx.fxml;

    // Open the package for reflective access by javafx.fxml and javafx.base
    opens com.example.dairy.Nupur to javafx.fxml, javafx.base;
    opens com.example.dairy.mahamud to javafx.fxml, javafx.base;
    //opens com.example.dairy.mahamud to javafx.fxml, javafx.graphics;

    opens com.example.dairy.ParvezHassan to javafx.fxml, javafx.graphics;
    exports com.example.dairy.ParvezHassan;




    exports com.example.dairy.mahamud to javafx.fxml;



    opens com.example.dairy.Samiul to javafx.fxml, javafx.graphics;
    exports com.example.dairy.Samiul.User7;
    exports com.example.dairy.Samiul.User8;

    //opens com.example.dairy.mahamud to javafx.fxml, javafx.graphics;
    //exports com.example.dairy.mahamud;


}
