package com.javaproject.helloworld.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PetConnector {

    private final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String DB_PATH = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_SCHEMA_NAME = "petstore";
    private final String DB_LOGIN = "root";
    private final String DB_PASSWORD = "590121vlad";

    private Connection connection;

    private Statement statement;

    public Statement getStatement() {
        return statement;
    }

    public PetConnector() {
        initDBDriver();
        initConnection();
    }

    private void initDBDriver() {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        String connectionURL = "jdbc:mysql://"+DB_PATH+ ":" + DB_PORT + "/" +DB_SCHEMA_NAME;

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = DriverManager.getConnection(connectionURL, DB_LOGIN, DB_PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
