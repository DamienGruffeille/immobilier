package fr.afpa.immobilier.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/immobilier", "root", "root");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from appart");

            while (resultSet.next()) {

                System.out.println("Numero appart : " + resultSet.getString("noappart"));
                System.out.println("Numero immeuble : " + resultSet.getString("noimm"));
                System.out.println("Nombre pièces : " + resultSet.getString("nbrepieces"));
                System.out.println("Prix : " + resultSet.getString("prix"));
                System.out.println("Surface : " + resultSet.getString("surface"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        launch();
    }
}