package com.codecool.shop.controller;

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


@WebServlet(urlPatterns = {"/payment"})

public class PaymentController extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)

        throws ServletException, IOException {

        ShoppingCart shoppingCart = ShoppingCart.getInstance();


        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//
        context.setVariable("shoppingcart", shoppingCart.getAll());
        context.setVariable("totalPrice", ShoppingCart.getTotalPrice());
        engine.process("product/payment_info.html", context, resp.getWriter());
    }
}

