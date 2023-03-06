package com.javaproject.helloworld.model.dao;

import com.javaproject.helloworld.jdbc.PetConnector;

import java.sql.SQLException;

public class PetDAOImpl implements PetDAO {

    private PetConnector connector;

    public PetDAOImpl() {
        connector = new PetConnector();
    }

    @Override
    public void create(String query) {
        try {
            connector.getStatement().executeQuery(query).close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getUser(String query) {

    }

    @Override
    public void delete(String query) {

    }
}
