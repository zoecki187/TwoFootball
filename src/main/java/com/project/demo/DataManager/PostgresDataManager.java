package com.project.demo.DataManager;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class PostgresDataManager {
    String databaseURL = "jdbc:postgres://ec2-3-213-66-35.compute-1.amazonaws.com:5432/d4nfg4ibkbum92";

    String username = "pketljgqsawesm";

    String password = "1b79992c716250de0cbc8182890991378b6054939a98df1726c7d032eb049f1b";

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
}
