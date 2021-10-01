package com;

import com.service.Consult;
import com.service.ProductManager;

public class Main {

    public static void main(final String[] args) {
        Consult consult = new Consult();
        ProductManager productManager = new ProductManager();
        productManager.deliveryOfGoods("D", "shale", 38, 12, 2000);
        productManager.deliveryOfGoods("D", "bots", 44, 8, 15000);
//        consult.getAllDamsShoes();
        consult.getHelp();
    }
}
