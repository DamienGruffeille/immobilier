module fr.afpa.immobilier {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;
    requires java.naming;

    opens fr.afpa.immobilier.controllers;
    opens fr.afpa.immobilier.data;
    exports fr.afpa.immobilier.app;
    
}