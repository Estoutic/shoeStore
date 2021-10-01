package service;

import Db.DbManager;
import lombok.Getter;

import java.util.Scanner;

@Getter
public class Consult {
    private String name;
    DbManager dbManager = DbManager.getInstance();
    Scanner in = new Scanner(System.in);
    public Consult(){
        this.name = "Natasha";

    }
    public void getHelp(){
        System.out.println(String.format("Hello, i`m your consult !s , what you looking for?",name));
        System.out.println("What's type of sex shoe type do you need");
        String article = in.next();
        dbManager.getProductInfo(article);

    }

}
