package com.codecool.shop.dao.implementation;

import com.codecool.shop.model.Product;

import java.util.ArrayList;

public class ShoppingCart {


    private static ArrayList<Product> shoppingCartList = new ArrayList<>();

    private static ShoppingCart instance = null;

    private ShoppingCart(){
    }

    public static ShoppingCart getInstance() {
        if (instance == null) {
            instance = new ShoppingCart();
        }
        return instance;
    }

    public void add(Product product){

        shoppingCartList.add(product);
    }

    public void remove(Product product){

        shoppingCartList.remove(product);
    }

    public static ArrayList<Product> getAll(){
        return shoppingCartList;
    }

}

