package fr.afpa.immobilier.data;

import javax.sql.DataSource;

/*
Classe contenant une instance d'une datasource pouvant etre utilisée partout.
 */
public final class AppDataSource {

    public static final DataSource INSTANCE = new DataSourceFactory().createMySqlDataSource();


    private AppDataSource() {
    }
}
