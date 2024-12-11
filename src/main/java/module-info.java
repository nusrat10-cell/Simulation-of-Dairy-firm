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

        exports com.example.dairy;
        exports com.example.dairy.Nupur;

        opens com.example.dairy to javafx.graphics;
        opens com.example.dairy.Nupur to javafx.fxml;
        }

//=======

    //opens com.example.dairy to javafx.fxml;
    //exports com.example.dairy.mahamud;
    //opens com.example.dairy.mahamud to javafx.fxml;
    //opens com.example.dairy.Samiul.User7 to javafx.fxml;
    //opens com.example.dairy.Samiul.User8 to javafx.fxml;

    //exports com.example.dairy;


    //opens com.example.dairy.ParvezHassan to javafx.fxml, javafx.graphics;
    //exports com.example.dairy.ParvezHassan;
//}
//>>>>>>> 9bc02a48fdd84a39b6db8b30a6ba4c38024277de
