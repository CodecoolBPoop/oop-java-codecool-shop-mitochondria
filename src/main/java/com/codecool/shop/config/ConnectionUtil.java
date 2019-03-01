package com.codecool.shop.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ConnectionUtil {

    private static ConnectionUtil instance;
    private Connection connection;
    private Connection productionConnection;

    public static ConnectionUtil getInstance(){

        if (null == instance){
            instance = new ConnectionUtil();
            return instance;
        } else {
            return instance;
        }
    }

    public void connfig(Map<String, String> data){
        connection = initializeConnectionWith(
                data.get("driver"),
                data.get("url"),
                data.get("user"),
                data.get("password")
        );



    }

    public Connection getConnection() {
        return connection;
    }

    private Connection initializeConnectionWith(String driver, String url, String user, String password){

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", password);

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }









}
