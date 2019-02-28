package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.ConnectionUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.ProductCategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class ProductCategoryDaoJDBC implements ProductCategoryDao {

    private Connection connection;
    private static ProductCategoryDaoJDBC instance = null;
    private static ProductCategoryDaoJDBC testInstance = null;

    // A private Constructor prevents any other class from instantiating.
    private ProductCategoryDaoJDBC() {

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
        return null;
    }

    @Override
    public ProductCategory findByName(String cat) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<ProductCategory> getAll() {
        return null;
    }
}
