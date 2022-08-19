package fr.afpa.immobilier.controllers;

import fr.afpa.immobilier.app.Main;
import fr.afpa.immobilier.data.AppDataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Button btnAjouter;

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
    void ajouterAppart(ActionEvent event) {
        try {
            ajoutAppart();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void effacer(ActionEvent event) {
        effacerLabel();
    }

    @FXML
    void rechercherAppart(ActionEvent event) {
        afficherInfosAppart();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        remplirCbx();
    }

    private void remplirCbx() {

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

    private void afficherInfosAppart() {
        //System.out.println(cbxImmeuble.getValue());
        String choix = cbxImmeuble.getValue();
        System.out.println(choix);

        try (
                final Connection connection = AppDataSource.INSTANCE.getConnection();
                final Statement statement = connection.createStatement();
                final ResultSet resultSet = statement.executeQuery(
                        "SELECT * FROM `appart` " +
                                "JOIN immeuble ON appart.noimm = immeuble.noimm " +
                                "WHERE noappart =" + choix);

        ) {

            while (resultSet.next()) {
                lblNumAppart.setText(resultSet.getString("noappart"));
                lblNbPieces.setText(resultSet.getString("nbrepieces"));
                lblSurface.setText(resultSet.getString("surface"));
                lblPrix.setText(resultSet.getString("prix"));
                lblNumImmeuble.setText(resultSet.getString("noimm"));
                lblAdresse.setText(resultSet.getString("immeuble.adresse"));
                lblVille.setText(resultSet.getString("immeuble.ville"));
                //System.out.println("Prix : " + resultSet.getString("prix"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void effacerLabel() {
        lblNumAppart.setText("");
        lblNbPieces.setText("");
        lblSurface.setText("");
        lblPrix.setText("");
        lblNumImmeuble.setText("");
        lblAdresse.setText("");
        lblVille.setText("");
    }

    private void ajoutAppart() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/creationAppart.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Création appartement");
        stage.show();
    }
}

