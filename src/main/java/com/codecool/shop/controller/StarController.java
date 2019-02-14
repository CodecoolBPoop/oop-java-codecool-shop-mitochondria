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

@WebServlet(urlPatterns = {"/stars"})
public class StarController extends HttpServlet {


    ProductDao productDataStore = ProductDaoMem.getInstance();
    ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
    SupplierDao supplierDataStore = SupplierDaoMem.getInstance();
    ShoppingCart shoppingCart = ShoppingCart.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        context.setVariable("products", productDataStore.getBy(productCategoryDataStore.findByName("Star")));


        engine.process("product/stars.html", context, resp.getWriter());
    }




}
