package com.codegym.huyc08.test;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.entity.PromotionFactory;
import com.codegym.huyc08.service.JsonFileHandler;
import com.codegym.huyc08.service.MyFileHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PromotionTest {
    public static void main(String[] args) {
        Scanner SCANNER = new Scanner(System.in);
        PromotionFactory factory = new PromotionFactory();
        Promotion promotion1 = factory.createPromotion(1,"KM01", "10/10/2023", "01/11/2023", 0, 10);
        Promotion promotionExpired1 = factory.createPromotion(2,"KM02", "01/10/2023", "02/10/2023", 0, 10);
        Promotion promotionExpired2 = factory.createPromotion(3,"KM03", "10/10/2023", "31/12/2023", 0, 10);
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(promotion1);
        promotions.add(promotionExpired1);
        promotions.add(promotionExpired2);
        MyFileHandler fileHandler = new JsonFileHandler();
        fileHandler.saveToFile(Constants.PROMOTION_FILE_PATH, promotions);
    }
}
