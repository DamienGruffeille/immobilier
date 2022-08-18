package fr.afpa.immobilier.data;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;

/*
Classe permettant de générer une "datasource", c'est utile des les cas où on a plusieurs bases de données ou on
veut pourvoir changer de type de base facilement.
 */
public class DataSourceFactory {

    public DataSource createMySqlDataSource() {

        final MysqlDataSource output = new MysqlDataSource();

        output.setURL(DataSourceConfig.URL);
        output.setUser(DataSourceConfig.USERNAME);
        output.setPassword(DataSourceConfig.PASSWORD);

        return output;
    }


}
