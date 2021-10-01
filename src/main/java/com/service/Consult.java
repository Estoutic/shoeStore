package com.service;

import com.Db.DbManager;
import com.models.ProductDao;
import lombok.Getter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Getter
public class Consult {
    private final String name;
    DbManager dbManager = DbManager.getInstance();
    Scanner in = new Scanner(System.in);
    List<ProductDao> result;
    public Consult() {
        this.name = "Natasha";
        this.result = new ArrayList<>();
    }

    public void getHelp() {
        System.out.printf("Hello, i`m your consult %s , what you looking for?\n", name);
        System.out.println("What's type of sex shoe type do you need");
        String article = in.next();
        List<ProductDao> res = dbManager.getAllProductInfo();
        for (ProductDao productDao : res) {
            if (productDao.getArticle().equals(article)) {
                System.out.println(productDao.getName());
                result.add(productDao);
            }

        }
        System.out.println(result);
    }

//            ProductDao productDao = dbManager.getProductInfo(article);
//        System.out.printf(" article : %s\n name : %s\n size: %s\n numberPair: %s\n price: %s\n",
//                productDao.getArticle(),
//                productDao.getName(),
//                productDao.getSize(),
//                productDao.getNumberPair(),
//                productDao.getPrice());
//
//    }
    public void getAllDamsShoes(){
        System.out.println("Please enter shoe name, what you want");
        String shoesName = in.next();
        System.out.println("Please enter shoe size, what you want");
        try {
            int shoesSize = in.nextInt();
        }catch (InputMismatchException e){
            System.out.println("Sorry, but you enter wrong type");
        }
        List<ProductDao> res = dbManager.getAllProductInfo();
        for (ProductDao productDao:res){
            if (productDao.getArticle().equals("D")){
                System.out.println(productDao.getName() + productDao.getArticle());
                result.add(productDao);
            }
//            if (productDao.getName().equals(shoesName) & productDao.getSize().equals(String.valueOf(shoesSize))){
//                result.add(productDao);
//            }
        }
        if (result.size() == 0){
            System.out.println("Sorry, but we haven't shoes what you want");
        }else{
            System.out.println(result);
        }
    }

}
