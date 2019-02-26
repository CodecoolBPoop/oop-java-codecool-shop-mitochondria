package com.codecool.shop.connection;

import com.codecool.shop.dao.implementation.ProductDaoMem;

import java.sql.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DB {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "milanszakacs";
        String password = "postgres";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM applicants");{
                while (rs.next()) {
                    String rs1 = rs.getString(2);
                    ProductDaoMem pdm = ProductDaoMem.getInstance();
                }
            }


        } catch (SQLException ex) {

            Logger lgr = Logger.getLogger(DB.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}
