package com.softserve.edu.greencity.ui.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public final class ManagerDao {
    private static volatile ManagerDao instance = null;
    private String username;
    private String password;
    private String url;
    private Map<Long, Connection> connections;

    private ManagerDao() {
        connections = new HashMap<>();
        registerDriver();
        readProperties();
    }

    private void registerDriver() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void readProperties() {
        username = "postgres";
        password = "root";
        url = "jdbc:postgresql://localhost:5432/greencity";
    }

    public static ManagerDao get() {
        if (instance == null) {
            synchronized (ManagerDao.class) {
                if (instance == null) {
                    instance = new ManagerDao();
                }
            }
        }
        return instance;
    }

    public static void closeAllConnection() {
        if (instance != null) {
            for (Map.Entry<Long, Connection> entry : instance.connections.entrySet()) {
                try {
                    entry.getValue().close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    public Connection getConnection() {
        long idThread = Thread.currentThread().getId();
        Connection result = connections.get(idThread);
        if (result == null) {
            result = createConnection();
            connections.put(idThread, result);
        }
        return result;
    }

    public Statement getStatement() {
        Statement result = null;
        try {
            result = getConnection().createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

    private Connection createConnection() {
        Connection result = null;
        try {
            result = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return result;
    }

}
