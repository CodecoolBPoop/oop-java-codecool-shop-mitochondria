//package com.codecool.shop.connection;
//
//import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
//
//import java.sql.*;
//import java.sql.Connection;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class DB {
//
//    String url = "jdbc:postgresql://localhost:5432/postgres";
//    String user = "milanszakacs";
//    String password = "postgres";
//
//    Connection conn = null;
//
//    public DB(){
//
//        try {
//            conn = DriverManager.getConnection(url, user, password);
//        } catch (SQLException e) {
//            System.out.println("Failed to connect to database.");
//        }
//
//    }
//
//    public Connection getConnection() {
//
//        try {
//            Connection con = DriverManager.getConnection(url, user, password);
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery("SELECT * FROM applicants");{
//                while (rs.next()) {
//                    String rs1 = rs.getString(2);
//                    ProductDaoMem pdm = ProductDaoMem.getInstance();
//                }
//            }
//
//
//        } catch (SQLException ex) {
//
//            Logger lgr = Logger.getLogger(DB.class.getName());
//            lgr.log(Level.SEVERE, ex.getMessage(), ex);
//        }
//    }
//}
