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
        Promotion promotion1 = factory.createPromotion(1,"KM01", "10/10/2023", "20/11/2023", 0, 10);
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(promotion1);
        MyFileHandler fileHandler = new JsonFileHandler();
        fileHandler.saveToFile(Constants.PROMOTION_FILE_PATH, promotions);
    }
}
