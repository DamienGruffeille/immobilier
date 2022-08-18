package fr.afpa.immobilier.controllers;

import fr.afpa.immobilier.data.AppDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnEffacer;

    @FXML
    private Button btnValider;

    @FXML
    private ComboBox<String> cbxImmeuble;

    @FXML
    private Label lblAdresse;

    @FXML
    private Label lblNbPieces;

    @FXML
    private Label lblNumAppart;

    @FXML
    private Label lblNumImmeuble;

    @FXML
    private Label lblPrix;

    @FXML
    private Label lblSurface;

    @FXML
    private Label lblVille;

    @FXML
    void effacer(ActionEvent event) {

    }

    @FXML
    void rechercherAppart(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remplirCbx();
    }

    private void remplirCbx(){

        final ObservableList<String> numAppart = FXCollections.observableArrayList();

        try (
                final Connection connection = AppDataSource.INSTANCE.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery("select noappart from appart");
        ) {
            while (resultSet.next()) {
                numAppart.add(resultSet.getString("noappart"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cbxImmeuble.setItems(numAppart);

    }
}

