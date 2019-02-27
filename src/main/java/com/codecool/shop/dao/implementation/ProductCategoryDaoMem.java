package com.codecool.shop.dao.implementation;


import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductCategoryDaoMem implements ProductCategoryDao {

    private List<ProductCategory> data = new ArrayList<>();
    private static ProductCategoryDaoMem instance = null;
    private static ProductCategoryDaoMem testInstance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private ProductCategoryDaoMem() {
    }

    public static ProductCategoryDaoMem getInstance() {
        if (instance == null) {
            instance = new ProductCategoryDaoMem();
        }
        return instance;
    }

    public static ProductCategoryDaoMem getTestInstance() {
        if (testInstance == null) {
            testInstance = new ProductCategoryDaoMem();
        }
        return testInstance;
    }

    @Override
    public void add(ProductCategory category) {
        category.setId(data.size() + 1);
        data.add(category);
    }

    @Override
    public ProductCategory find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public ProductCategory findByName(String cat) {
        return data.stream().filter(t -> Objects.equals(t.getName(), cat)).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public List<ProductCategory> getAll() {
        return data;
    }
}
