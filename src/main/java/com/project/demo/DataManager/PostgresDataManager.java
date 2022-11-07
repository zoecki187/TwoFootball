package com.project.demo.DataManager;

import com.project.demo.Anwender.Nutzer;
import com.project.demo.ClubPraeferenz.Liga;
import com.project.demo.ClubPraeferenz.Verein;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


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
//Datensätze hinzufügen
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
            String udapteSQL = "INSERT into nutzer (email, praefverein, praefliga) VALUES (" +
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
    //Tabellen erzeugen
    public void createTableNutzer() {

       Statement stmt = null;
        Connection connection = null;
        try{
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS nutzer";
            stmt.executeUpdate(dropTable);

            String createTable = "CREATE TABLE nutzer (" +
                    "email varchar(250) NOT NULL, " +
                    "PraefVerein int NOT NULL, " +
                    "PraefLiga int NOT NULL," +
                    "CONSTRAINT PRIMARY KEY(email))";
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
    //Getter-Methoden
    public Collection<Liga> getAllLigen() {

        List<Liga> ligenListe = new ArrayList<>();
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM ligen");
            while (rs.next()) {
                ligenListe.add(
                        new Liga(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("anzvereine")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return ligenListe;
    }
    public Collection<Nutzer> getAllNutzer() {

        List<Nutzer> nutzerListe = new ArrayList<>();
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nutzer");
            while (rs.next()) {
                nutzerListe.add(
                        new Nutzer(
                                rs.getString("email"),
                                rs.getInt("praefverein"),
                                rs.getInt("praefliga")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return nutzerListe;
    }
    public Collection<Verein> getAllVereine() {

        List<Verein> vereinListe = new ArrayList<>();
        Statement stmt = null;
        Connection connection = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM vereine");
            while (rs.next()) {
                vereinListe.add(
                        new Verein(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getInt("ligaid"),
                                rs.getInt("externeid")
                        )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vereinListe;
    }

    public Verein getLiebVerein(String nutzerEmail) {

        PreparedStatement stmt = null;
        Connection connection = null;
        Verein liebVerein = null;

        try {
            connection = basicDataSource.getConnection();
            stmt = connection.prepareStatement("SELECT * FROM vereine WHERE id=( SELECT praefverein FROM nutzer WHERE email='timo.werner@gmx.de'");
            stmt.setString(1, nutzerEmail);
            ResultSet rs = stmt.executeQuery();

            liebVerein = new Verein(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("ligaid"),
                    rs.getInt("externeid")
            );
            return liebVerein;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            stmt.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
