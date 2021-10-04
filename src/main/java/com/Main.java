package com;

import com.service.Consult;
import com.service.ProductManager;

public class Main {

    public static void main(final String[] args) {
        Consult consult = new Consult();
        ProductManager productManager = new ProductManager();
//        productManager.deliveryOfGoods("D", "gawnodavki", 44, 8, 15000);
//        productManager.deliveryOfGoods("D", "bot", 44, 8, 15000);
        consult.getDamsHelp();
        consult.getHelp();
    }
}
