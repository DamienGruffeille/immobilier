module fr.afpa.immobilier {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens fr.afpa.immobilier.app to javafx.fxml;
    opens fr.afpa.immobilier.controllers;
    exports fr.afpa.immobilier.app;
}