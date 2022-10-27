package com.project.demo.DataManager.Postgres;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.Statement;



public class PostgresDataManager {
    String databaseURL = "postgres://pketljgqsawesm:1b79992c716250de0cbc8182890991378b6054939a98df1726c7d032eb049f1b@ec2-3-213-66-35.compute-1.amazonaws.com:5432/d4nfg4ibkbum92";

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

        // Be carefull: It deletes data if table already exists.
        //
        Statement stmt = null;
        Connection connection = null;


    }
}
