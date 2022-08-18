package fr.afpa.immobilier.data;


/*
Classe de configuration, en réalité se serait mieux de récupérer les infos avec un fichier externe.
 */
public final class DataSourceConfig {

    public static final String URL = "jdbc:mysql://localhost:3306/immobilier";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root";


    private DataSourceConfig() {
    }

}
