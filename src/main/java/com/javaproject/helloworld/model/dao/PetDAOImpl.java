package com.javaproject.helloworld.model.dao;

import com.javaproject.helloworld.jdbc.PetConnector;
import org.springframework.test.jdbc.JdbcTestUtils;

import java.sql.SQLException;

public class PetDAOImpl implements PetDAO {

    private PetConnector connector;

    public PetDAOImpl() {
        connector = new PetConnector();
    }

    @Override
    public void create(String query) {
        try {
            connector.getStatement().executeUpdate(query);
            connector.getStatement().close();
        } catch (SQLException e) {
            System.out.println("Your query did not executed ");
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
