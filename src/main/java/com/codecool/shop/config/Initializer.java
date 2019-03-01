package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.*;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Map<String, String> connectionData = new HashMap<>();
        connectionData.put("driver", "org.postgresql.Driver");
        connectionData.put("url", "jdbc:postgresql://localhost:5432/codecoolshop");
        connectionData.put("user", "postgres");
        connectionData.put("password", "1987Epiphone");
        ConnectionUtil.getInstance().connfig(connectionData);
        Connection connection =  ConnectionUtil.getInstance().getConnection();

        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
        ShoppingCart shoppingCart = ShoppingCart.getInstance();


        //setting up a new supplier
        Supplier empire = new Supplier("Empire", "A huge empire leading by the Emperor");
        supplierDataStore.add(empire);
        Supplier republic = new Supplier("Republic", "A senate leaded Republic");
        supplierDataStore.add(republic);

        ProductCategoryDao jdbccat = ProductCategoryDaoJDBC.getInstance();
        System.out.println(jdbccat.findByName("Planet"));

        //setting up a new product category
        ProductCategory star = new ProductCategory("Star", "thermonuclear", "Luminous and thermonuclear gas objects.");
        productCategoryDataStore.add(star);
        ProductCategory planet = new ProductCategory("Planet", "habitable", "All object you can live on.");
        productCategoryDataStore.add(planet);
        ProductCategory blackhole = new ProductCategory("Black Hole", "singularity", "Gravity traps.");
        productCategoryDataStore.add(blackhole);


        //setting up products and printing it
        productDataStore.add(new Product("Sol", 398.8f, "USD", "A really young and shiny star. Nice yellow color.", star, empire));
        productDataStore.add(new Product("Rigel", 479, "USD", "The shiniest star of the Orion. Nice blue color.", star, republic));
        productDataStore.add(new Product("Arcturus", 689, "USD", "A huge red star. A little bit old.", star, empire));
        productDataStore.add(new Product("Sirius B", 557, "USD", "This is a big binary star in the Canis Majoris. Shiny white color.", star, republic));
        productDataStore.add(new Product("Earth", 199.9f, "USD", "Fantastic price. A lot of inhabitors included. Great landscapes, and different seasons.", planet, empire));
        productDataStore.add(new Product("Mars", 179, "USD", "A little bit dusty, low water and oxigen. Nice red color. Has a lot of potential.", planet, republic));
        productDataStore.add(new Product("Saturn", 267.8f, "USD", "A gas giant. Has a nice ring around itself.", planet, republic));
        productDataStore.add(new Product("Messier 32", 243, "USD", "It was a huge galaxy once, now its just a black hole, but the price is really low.", blackhole, empire));
        productDataStore.add(new Product("NGC 3377", 496.9f, "USD", "Fantastic price. Supermassive black hole.", blackhole, republic));
        productDataStore.add(new Product("Sagittarius A", 479, "USD", "Its in the center of the Milky Way. Supermassive black hole.", blackhole, empire));


    }
}
