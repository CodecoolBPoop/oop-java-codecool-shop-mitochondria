package com.codecool.shop.controller;

import com.codecool.shop.config.TemplateEngineUtil;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/test"})
public class Test extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("szia!");

//        ProductDao productDataStore = ProductDaoMem.getInstance();
//        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
//        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
//        ShoppingCart shoppingCart = ShoppingCart.getInstance();
//
////        Map params = new HashMap<>();
////        params.put("category", productCategoryDataStore.find(1));
////        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));
//
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
////        context.setVariables(params);
//        context.setVariable("recipient", "World");
//        context.setVariable("category", productCategoryDataStore.getAll());
//        context.setVariable("products", productDataStore.getAll());
//        context.setVariable("supplier", supplierDataStore.getAll());
//        context.setVariable("shoppingcart", ShoppingCart.getAll());
//        context.setVariable("all", "All Category");
        engine.process("product/test.html", context, resp.getWriter());
    }

}
