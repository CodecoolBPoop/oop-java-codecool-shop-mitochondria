package com.codecool.shop.dao.implementation.jdbc;

import com.codecool.shop.connection.DbConnection;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try {
            Statement statement = connection.conn.createStatement();
            String sql = "select * from product join supplier on product.supplier_id = supplier.id join product_category on product.category_id = product_category.id where product.id = ?";
            PreparedStatement preparedSt = connection.conn.prepareStatement(sql);
            preparedSt.setInt(1, id);
            ResultSet results = preparedSt.executeQuery();
            Product searched = new Product();
            getOneProductData(results, searched);
            statement.close();
            if (searched.getName().equals("")) {
                throw new NullPointerException("No stuff by this id exists.");
            }
            return searched;

        } catch (SQLException e) {
            System.out.printf("I couldn't find product of id %s%n", id);
            e.printStackTrace();
        }
        return null;
    }

        @Override
    public void remove(int id) {

    }

    private void getOneProductData(ResultSet results, Product searched) throws SQLException {
        while (results.next()) {
            searched.setId(results.getInt("id"));
            searched.setName(results.getString("name"));
            searched.setDescription(results.getString("description"));
            searched.setPrice(results.getFloat("default_price"), "USD");
            searched.setSupplier(new Supplier(results.getString(9), results.getString(10)));
            searched.setProductCategory(new ProductCategory(results.getString(11), results.getString(12), results.getString(13)));
        }
    }

    @Override
    public List<Product> getAll() {
        ArrayList<Product> everyProduct = new ArrayList<>();

        try {
            String sql = "select * from product";
            PreparedStatement preppedStmnt = connection.conn.prepareStatement(sql);
            ResultSet results = preppedStmnt.executeQuery();
            everyProduct = collectProductsToList(results);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return everyProduct;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }

    private ArrayList<Product> collectProductsToList(ResultSet results) throws SQLException {
        ArrayList<Product> everyProduct = new ArrayList<>();
        while (results.next()) {
            Product current = new Product();
            current.setId(results.getInt("id"));
            current.setName(results.getString("name"));
            current.setDescription(results.getString("description"));
            current.setPrice(results.getFloat("default_price"), "USD");
            everyProduct.add(current);
        }
        return everyProduct;
        //this is a comment
    }

}
