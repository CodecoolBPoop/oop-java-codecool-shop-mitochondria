package com.codecool.shop.dao.implementation.mem;

import com.codecool.shop.model.Product;

import java.util.ArrayList;

public class ShoppingCart {


    private static ArrayList<Product> shoppingCartList = new ArrayList<>();
    private static ShoppingCart instance = null;
    private static float totalPrice;
    private static float totalPriceWithShipping;
    public static float shipping1 = 30;
    public static float shipping3 = 20;
    public static float shipping7 = 10;


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
        setTotalPrice(product.getFloatPrice());

    }

    public void remove(Product product){

        shoppingCartList.remove(product);
    }

    public static ArrayList<Product> getAll(){
        return shoppingCartList;
    }

    public static void setTotalPrice(float addedPrice){
        totalPrice += addedPrice;
    }

    public static float getTotalPrice(){
        return totalPrice;
    }

    public static void setTotalPriceWithShipping(float shippingPrice){
        totalPrice += shippingPrice;
    }

    public static float getTotalPriceWithShipping(){
        return totalPriceWithShipping;
    }

}

