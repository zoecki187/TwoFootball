package com.project.demo.DataManager;

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

/*
    @Override
    public Collection<Task> getAllTasks(Student student) {

        List<Task> tasks = new ArrayList<>();

        return tasks;
    }

    @Override
    public void addTask(Task task, Student student) {

        Statement stmt = null;
        Connection connection = null;


    }
*/
    public void createTableUser() {

       Statement stmt = null;
        Connection connection = null;
        try{
            connection = basicDataSource.getConnection();
            stmt = connection.createStatement();
            String dropTable = "DROP TABLE IF EXISTS user";
            stmt.executeUpdate(dropTable);

            String createTable = "CREATE TABLE user (" +
                    "id SERIAL PRIMARY KEY, " +
                    "email varchar(250) NOT NULL, " +
                    "verein varchar(100) NOT NULL, " +
                    "passwort varchar(250) NOT NULL)";
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
}
