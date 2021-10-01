package com.service;

import com.Db.DbManager;
import com.models.ProductDao;
import lombok.Getter;

import java.util.ArrayList;
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
        System.out.println(dbManager.getProductInfo(article));

    }
    public void getAllDamsShoes(){
        System.out.println("Please enter shoe name, what you want");
        String shoesName = in.next();
        System.out.println("Please enter shoe size, what you want");
        int shoesSize = in.nextInt();
        List<ProductDao> res = dbManager.getAllProductInfo();
        for (ProductDao productDao:res){
            if (productDao.getName().equals(shoesName) & productDao.getSize().equals(String.valueOf(shoesSize))){
                result.add(productDao);
            }
        }
        if (result.size() == 0){
            System.out.println("Sorry, but we haven't shoes what you want");
        }else{
            System.out.println(result);
        }
    }

}
