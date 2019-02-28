package com.codecool.shop.dao.implementation;


import com.codecool.shop.config.ConnectionUtil;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SupplierDaoJDBC implements SupplierDao {

    private Connection connection;
    private static SupplierDaoJDBC instance = null;

    public static SupplierDaoJDBC getInstance() {
        if (instance == null){
            instance = new SupplierDaoJDBC();
        }
        return instance;
    }

    private SupplierDaoJDBC(){
        connection = ConnectionUtil.getInstance().getConnection();
    }

    @Override
    public void add(Supplier supplier) {

    }

    @Override
    public Supplier find(int id) {
        Supplier supplier;
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM supplier WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                supplier = new Supplier(rs.getString("name"), rs.getString("description"));
                supplier.setId(rs.getInt("id"));
                return supplier;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Supplier findByName(String sup) {


        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> allSuppliers = new ArrayList<>();
        PreparedStatement st = null;
        Supplier supplier;
        try {
            st = connection.prepareStatement("SELECT * FROM supplier");

            ResultSet rs = null;

            rs = st.executeQuery();


            while (rs.next()) {
                supplier = new Supplier(rs.getString("name"), rs.getString("description"));
                supplier.setId(rs.getInt("id"));
                allSuppliers.add(supplier);


                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allSuppliers;

    }

}