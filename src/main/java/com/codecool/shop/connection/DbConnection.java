package com.codecool.shop.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    String url = "jdbc:postgresql://localhost:5432/codecoolshop";
    String user = "milanszakacs";
    String password = "milu12191";

    public Connection conn = null;

    public DbConnection(){

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("Failed to connect to database.");
        }
    }

    public Connection getConn() {
        return conn;
    }
}
