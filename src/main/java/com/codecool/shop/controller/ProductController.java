package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.ShoppingCart;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/products"})
public class ProductController extends HttpServlet {


    ProductDao productDataStore = ProductDaoMem.getInstance();
    ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
    SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
    ShoppingCart shoppingCart = ShoppingCart.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

//        Map params = new HashMap<>();
//        params.put("category", productCategoryDataStore.find(1));
//        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariables(params);
        context.setVariable("recipient", "World");
        context.setVariable("category", productCategoryDataStore.getAll());
        context.setVariable("products", productDataStore.getAll());
        context.setVariable("supplier", supplierDataStore.getAll());
        context.setVariable("shoppingcart", ShoppingCart.getAll());
        context.setVariable("all", "All Category");
        context.setVariable("all2", "All Suppliers");
        engine.process("product/products.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {



        String testText = req.getParameter("testName");
        String testText2 = req.getParameter("testName2");


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());



        if (testText.equalsIgnoreCase("All Categories") && testText2.equalsIgnoreCase("All Suppliers")) {
            context.setVariable("products", productDataStore.getAll());
        }
        else if (testText2.equalsIgnoreCase("All Suppliers") && !testText.equalsIgnoreCase("All Categories")) {
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.findByName(testText)));
        } else {
            context.setVariable("products", productDataStore.getBy(supplierDataStore.findByName(testText2)));
            System.out.println("intext2");
        }


//        if (testText2.equalsIgnoreCase("All Supplier")) {
//            context.setVariable("products", productDataStore.getAll());
//            System.out.println("all supplier");
//        } else {
//            context.setVariable("products", productDataStore.getAll());
//            System.out.println("not all supplier");
//        }


        context.setVariable("category", productCategoryDataStore.getAll());
        context.setVariable("supplier", supplierDataStore.getAll());
        context.setVariable("shoppingcart", ShoppingCart.getAll());
        context.setVariable("all", "All Categories");
        context.setVariable("all2", "All Suppliers");
        engine.process("product/index.html", context, resp.getWriter());
    }

}
