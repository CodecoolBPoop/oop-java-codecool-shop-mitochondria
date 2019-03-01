package com.codecool.shop.dao.implementation;

import com.codecool.shop.config.ConnectionUtil;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDao {
    private Connection connection;
    private static ProductDaoJDBC instance = null;

    private ProductDaoJDBC() {
        connection = ConnectionUtil.getInstance().getConnection();

    }

    public static ProductDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductDaoJDBC();
        }
        return instance;
    }


    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        Product product;
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM product JOIN product_category" +
                    " ON product.product_category_id = product_category.id" +
                    " JOIN supplier ON product.supplier_id = supplier.id" +
                    "  WHERE product.id = ?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                product = new Product(rs.getString("name"), rs.getFloat("default_price"),
                        rs.getString("currency_string"), rs.getString("description"),
                        new ProductCategory(rs.getString(9),
                                rs.getString(10), rs.getString(11)),
                        new Supplier(rs.getString(13), rs.getString(14)));
                product.setId(rs.getInt("id"));
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        List<Product> allProduct = new ArrayList<>();
        PreparedStatement st = null;
        Product product;
        try {
            st = connection.prepareStatement("SELECT * FROM product JOIN product_category" +
                    " ON product.product_category_id = product_category.id" +
                    " JOIN supplier ON product.supplier_id = supplier.id");

            ResultSet rs = null;

            rs = st.executeQuery();


            while (rs.next()) {
                product = new Product(rs.getString("name"), rs.getFloat("default_price"),
                        rs.getString("currency_string"), rs.getString("description"),
                        new ProductCategory(rs.getString(9),
                                rs.getString(10), rs.getString(11)),
                        new Supplier(rs.getString(13), rs.getString(14)));
                product.setId(rs.getInt("id"));
                allProduct.add(product);



            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProduct;
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        int supplierId = supplier.getId();
        List<Product> allProduct = new ArrayList<>();
        PreparedStatement st = null;
        Product product;

        try {
            st = connection.prepareStatement("SELECT * FROM product JOIN product_category" +
                    " ON product.product_category_id = product_category.id" +
                    " JOIN supplier ON product.supplier_id = supplier.id WHERE supplier.id = ?");

            st.setInt(1, supplierId);
            ResultSet rs = null;

            rs = st.executeQuery();


            while (rs.next()) {
                product = new Product(rs.getString("name"), rs.getFloat("default_price"),
                        rs.getString("currency_string"), rs.getString("description"),
                        new ProductCategory(rs.getString(9),
                                rs.getString(10), rs.getString(11)),
                        new Supplier(rs.getString(13), rs.getString(14)));
                product.setId(rs.getInt("id"));
                allProduct.add(product);


                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProduct;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
