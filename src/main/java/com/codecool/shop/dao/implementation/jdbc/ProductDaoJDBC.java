package com.codecool.shop.dao.implementation.jdbc;

import com.codecool.shop.connection.DbConnection;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDao {

    private static ProductDaoJDBC instance = null;
    public DbConnection connection = new DbConnection();

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductDaoJDBC() {
    }

    public static ProductDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductDaoJDBC();
        }
        return instance;
    }

    @Override
    public void add(Product product) {
        try {
            Statement st = connection.conn.createStatement();
            String sqlQuery = "insert into product (name, description, price, currency) values (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.conn.prepareStatement(sqlQuery);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setFloat(3, product.getFloatPrice());
            preparedStatement.setString(4, product.getDefaultCurrency().toString());
            preparedStatement.execute();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }

}
