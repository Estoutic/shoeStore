package com.service;

import com.Db.DbManager;
import com.models.ProductDao;
import lombok.Getter;

import java.util.List;
import java.util.Scanner;

@Getter
public class Consult {
    private final String name;
    DbManager dbManager = DbManager.getInstance();
    Scanner in = new Scanner(System.in);

    public Consult() {
        this.name = "Natasha";
    }

    public void getHelp() {
        System.out.printf("Hello, i`m your consult %s , what you looking for?\n", name);
        System.out.println("What's type of sex shoe type do you need");
        String article = in.next();
        List<ProductDao> productDaos = dbManager.getArticleShoes(article);
        for (ProductDao productDao : productDaos) {
            System.out.println("name: " + productDao.getName() + ", size: " + productDao.getSize() + ", mount: " + productDao.getNumberPair());
        }
    }

    public void getDamsHelp() {
        System.out.println("Please enter size what you need");
        int size = in.nextInt();
        List<ProductDao> productDaos = dbManager.getDamsProduct(size);
        for (ProductDao productDao : productDaos) {
            System.out.println("name: " + productDao.getName() + ", size: " + productDao.getSize() + ", mount: " + productDao.getNumberPair());
        }
    }
}