package fr.afpa.immobilier.controllers;

import fr.afpa.immobilier.data.AppDataSource;
import fr.afpa.immobilier.entites.Appartement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class ControllerNouvelAppart implements Initializable {
    @FXML
    private Button btnAnnuler;

    @FXML
    private Button btnCreer;

    @FXML
    private Button btnEffacer;

    @FXML
    private ComboBox<String> cbxNumImmeuble;

    @FXML
    private TextField txtNbPieces;

    @FXML
    private TextField txtNumAppart;

    @FXML
    private TextField txtPrix;

    @FXML
    private TextField txtSurface;

    @FXML
    void annulerCreation(ActionEvent event) {

    }

    @FXML
    void creerAppartement(ActionEvent event) {
        creationAppart();
    }

    @FXML
    void effacerChamps(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remplirCbx();
    }

    private void remplirCbx() {

        final ObservableList<String> numImmeuble = FXCollections.observableArrayList();

        try (
                final Connection connection = AppDataSource.INSTANCE.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery("select noimm from immeuble");
        ) {
            while (resultSet.next()) {
                numImmeuble.add(resultSet.getString("noimm"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cbxNumImmeuble.setItems(numImmeuble);
    }

    private void creationAppart() {

        Appartement appartement = new Appartement(
                parseInt(txtNumAppart.getText()),
                cbxNumImmeuble.getValue(),
                parseInt(txtNbPieces.getText()),
                parseInt(txtPrix.getText()),
                parseFloat(txtSurface.getText())
        );
        bddCreationAppart(appartement);
    }

    private void bddCreationAppart(Appartement appartement) {

        try (
                final Connection connection = AppDataSource.INSTANCE.getConnection();
                final Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate(
                    "INSERT INTO appart(noappart, noimm, nbrepieces, prix, surface)" +
                            "VALUES (" + appartement.getNumAppart() +
                            ", " + appartement.getNumImmeuble() +
                            ", " + appartement.getNbPieces() +
                            ", " + appartement.getPrix() +
                            ", " + appartement.getSurface() + ")");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
