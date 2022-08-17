module fr.afpa.immobilier {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens fr.afpa.immobilier.app to javafx.fxml;
    opens fr.afpa.immobilier.controllers;
    opens fr.afpa.immobilier.data;
    exports fr.afpa.immobilier.app;
    
}