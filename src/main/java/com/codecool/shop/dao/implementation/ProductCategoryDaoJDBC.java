package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.ConnectionUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryDaoJDBC implements ProductCategoryDao {

    private Connection connection;
    private static ProductCategoryDaoJDBC instance = null;
    private static ProductCategoryDaoJDBC testInstance = null;

    // A private Constructor prevents any other class from instantiating.
    private ProductCategoryDaoJDBC() {
        connection = ConnectionUtil.getInstance().getConnection();

    }

    public static ProductCategoryDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoJDBC();
        }
        return instance;
    }

    public static ProductCategoryDaoJDBC getTestInstance() {
        if (testInstance == null) {
            testInstance = new ProductCategoryDaoJDBC();
        }
        return testInstance;
    }

    @Override
    public void add(ProductCategory category) {

    }

    @Override
    public ProductCategory find(int id) {
        ProductCategory productCategory;
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM product_category WHERE id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                productCategory = new ProductCategory(rs.getString("name"), rs.getString("department"), rs.getString("description"));
                productCategory.setId(rs.getInt("id"));
                return productCategory;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ProductCategory findByName(String cat) {
        ProductCategory productCategory;
        try{
            PreparedStatement st = connection.prepareStatement("SELECT * FROM product_category WHERE name = ?");
            st.setString(1, cat);
            ResultSet rs = st.executeQuery();

            if (rs.next()){
                productCategory = new ProductCategory(rs.getString("name"), rs.getString("department"), rs.getString("description"));
                productCategory.setId(rs.getInt("id"));
                return productCategory;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> allProductCategory = new ArrayList<>();
        PreparedStatement st = null;
        ProductCategory productCategory;
        try {
            st = connection.prepareStatement("SELECT * FROM product_category");

            ResultSet rs = null;

            rs = st.executeQuery();


            while (rs.next()) {
                productCategory = new ProductCategory(rs.getString("name"),rs.getString("department"), rs.getString("description"));
                productCategory.setId(rs.getInt("id"));
                allProductCategory.add(productCategory);


                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProductCategory;
    }
}
