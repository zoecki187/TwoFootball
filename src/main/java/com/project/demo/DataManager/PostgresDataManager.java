package com.project.demo.DataManager;
import com.project.demo.ClubPraeferenz.Verein;
import com.project.demo.Anwender.*;

import com.project.demo.ClubPraeferenz.Liga;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class PostgresDataManager {
    String databaseURL = "jdbc:postgresql://ec2-44-210-228-110.compute-1.amazonaws.com:5432/d5lmics0j17aif?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";

    String username = "iepmatugkhzufr";

    String password = "8444a14f01de9cdd961af1c59c15cf55614003119454a50b69c273b03a7fe740";

    BasicDataSource basicDataSource;

    static PostgresDataManager postgresDataManager = null;

    private PostgresDataManager() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(databaseURL);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);
    }

    static public PostgresDataManager getPostgresDataManger() {
        if (postgresDataManager == null)
            postgresDataManager = new PostgresDataManager();
        return postgresDataManager;
    }

    public void addLigaToTab(Liga l) {

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into ligen (id, name, anzvereine) VALUES (" +
                    "'" + l.getligaID() + "', " +
                    "'" + l.getLiga() + "', " +
                    "'" + l.getVereine() + "')";

            stmt.executeUpdate(udapteSQL);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addVereinToTab(Verein v) {

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into vereine (id, name, ligaID, externeID) VALUES (" +
                    "'" + v.getVereinID() + "', " +
                    "'" + v.getVerein() + "', " +
                    "'" + v.getLigaID() + "', " +
                    "'" + v.getExterneID() + "')";

            stmt.executeUpdate(udapteSQL);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void addNutzerToTab(Nutzer n) {

        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String udapteSQL = "INSERT into nutzer (id, email, PraefVerein, PraefLiga) VALUES (" +
                    "'" + n.getNutzerID() + "', " +
                    "'" + n.getNutzerEmail() + "', " +
                    "'" + n.getNutzerPraefVerein() + "', " +
                    "'" + n.getNutzerPraefLiga() + "')";

            stmt.executeUpdate(udapteSQL);

            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public void createTableNutzer() {

       Statement stmt = null;
        Connection connection = null;
        try{
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS nutzer";
            stmt.executeUpdate(dropTable);

            String createTable = "CREATE TABLE nutzer (" +
                    "id SERIAL PRIMARY KEY, " +
                    "email varchar(250) NOT NULL, " +
                    "PraefVerein varchar(100) NOT NULL, " +
                    "PraefLiga varchar(250) NOT NULL)";
            stmt.executeUpdate(createTable);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        try{
            stmt.close();
            connection.close();

        }
        catch(SQLException e){

            e.printStackTrace();
        }

    }

    public void createTableLigen() {

        Statement stmt = null;
        Connection connection = null;
        try{
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS ligen";
            stmt.executeUpdate(dropTable);

            String createTable = "CREATE TABLE ligen (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name varchar(250) NOT NULL, " +
                    "anzvereine int NOT NULL)";
            stmt.executeUpdate(createTable);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        try{
            stmt.close();
            connection.close();

        }
        catch(SQLException e){

            e.printStackTrace();
        }

    }

    public void createTableVereine() {

        Statement stmt = null;
        Connection connection = null;
        try{
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS vereine";
            stmt.executeUpdate(dropTable);

            String createTable = "CREATE TABLE vereine (" +
                    "id SERIAL PRIMARY KEY, " +
                    "name varchar(250) NOT NULL, " +
                    "ligaID int NOT NULL, " +
                    "externeID int NOT NULL)";
            stmt.executeUpdate(createTable);

        }
        catch(SQLException e){
            e.printStackTrace();
        }
        try{
            stmt.close();
            connection.close();

        }
        catch(SQLException e){

            e.printStackTrace();
        }

    }
}
