package com.service;


import com.db.DbManager;

public class ProductManager {
    DbManager dbManager = DbManager.getInstance();

    public void deliveryOfGoods(String article, String name, Integer size, Integer numberPair, Integer price) {
        dbManager.insertProduct(article, name, size, numberPair, price);

    }
}
