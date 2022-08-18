package fr.afpa.immobilier.app;

import fr.afpa.immobilier.data.AppDataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main extends Application {
    public static void main(String[] args) {
        /* Les parenthèses servent à tout fermer à la fin de l'execution et quoi qu'il arrive,
        que ça se passe bien ou que ça s'arrête.
        */
//        try (
//                final Connection connection = AppDataSource.INSTANCE.getConnection();
//                final Statement statement = connection.createStatement();
//                final ResultSet resultSet = statement.executeQuery("select * from appart");
//        ) {
//            while (resultSet.next()) {
//
//                System.out.println("Numero appart : " + resultSet.getString("noappart"));
//                System.out.println("Numero immeuble : " + resultSet.getString("noimm"));
//                System.out.println("Nombre pièces : " + resultSet.getString("nbrepieces"));
//                System.out.println("Prix : " + resultSet.getString("prix"));
//                System.out.println("Surface : " + resultSet.getString("surface"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/fxml/mainFrame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Détails appartement");
        stage.setScene(scene);
        stage.show();
    }
}