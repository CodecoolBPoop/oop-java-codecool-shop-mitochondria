package com.codecool.shop.controller;

import com.codecool.shop.dao.implementation.mem.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.dao.implementation.mem.ShoppingCart;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/addtocart"})
public class AddToCartController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {

        ShoppingCart shoppingCart = ShoppingCart.getInstance();


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());

        for (int i = 0; i < (ProductDaoMem.getInstance().getAll().size()+1); i++) {

            String str = Integer.toString(i);

            if (req.getParameter(str) != null){
                shoppingCart.add(ProductDaoMem.getInstance().find(i));
            }
        }
        resp.sendRedirect(req.getContextPath() + "/products");
        System.out.println(ShoppingCart.getAll());
    }

}
