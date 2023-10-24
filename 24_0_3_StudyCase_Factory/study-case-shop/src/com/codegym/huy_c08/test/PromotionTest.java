package com.codegym.huy_c08.test;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Promotion;
import com.codegym.huy_c08.service.MyFileHandler;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class PromotionTest {
    public static void main(String[] args) {
        Promotion promotion1 = new Promotion(1, "KM01", "23/10/2023", "25/10/2023", 0, 10 );
        ArrayList<Promotion> promotions = new ArrayList<>();
        promotions.add(promotion1);
        MyFileHandler fileHandler = new MyFileHandler();
        fileHandler.saveToFile(Constants.PROMOTION_FILE_PATH, promotions);

        Type promotionType = new TypeToken<ArrayList<Promotion>>(){}.getType();
        ArrayList<Promotion> promotionsRead = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, promotionType);
        for (Promotion promotion: promotionsRead
             ) {
            System.out.println(promotion.toString());
        }
    }
}
