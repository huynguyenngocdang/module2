package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Promotion;
import com.codegym.huy_c08.entity.PromotionProgram;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PromotionService implements PromotionProgram, DateMatcher {
    private ArrayList<Promotion> promotions;
    private Promotion currentPromotion;
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final Type promotionType = new TypeToken<ArrayList<Promotion>>(){}.getType();

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public PromotionService() {
        this.promotions = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, promotionType );
    }


    @Override
    public Promotion createPromotionProgram(int promotionId, String promotionCode, String promotionDateStart, String promotionDateEnd, double promotionAmount, double promotionPercent) {
        return new Promotion(promotionId, promotionCode, promotionDateStart, promotionDateEnd, promotionAmount, promotionPercent);
    }
    public void addPromotionToList(Promotion newPromotion) {
        promotions.add(newPromotion);
    }
    public void savePromotion() {
        fileHandler.saveToFile(Constants.PROMOTION_FILE_PATH, promotions);
    }
    public int getNewId(){
        int max = 0;
        for (Promotion promotion: promotions
             ) {
            if (max < promotion.getPromotionId()) {
                max = promotion.getPromotionId();
            }
        }
        return  max + 1;
    }
    public void getAllPromotion() {
        for (Promotion promotion: promotions
             ) {
            System.out.println(promotion.toString());
        }
    }

    public boolean isPromotionExist(String promotionName){
        for (Promotion promotion: promotions
        ) {
            if (promotion.getPromotionCode().equals(promotionName)){
                return true;
            }
        }
        return false;
    }

    public boolean isPromotionExist(int promotionId){
        for (Promotion promotion: promotions
        ) {
            if (promotion.getPromotionId() == promotionId){
                return true;
            }
        }
        return false;
    }
    public void refresh(){
        promotions = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, promotionType);
    }
    public boolean validatePromotionName(String promotionName){
        Pattern pattern = Pattern.compile(Constants.PROMOTION_REGEX);
        Matcher matcher = pattern.matcher(promotionName);
        return matcher.matches();
    }


    @Override
    public boolean dateMatch(String dateText) {
        if (dateText == null || !dateText.matches(Constants.DATE_REGEX)) {
            return false;
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(dateText);
            return true;
        } catch (ParseException parseException) {
            return false;
        }
    }

    public boolean dateCorrect(String dateStart, String dateEnd)  {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date1 = dateFormat.parse(dateStart);
            Date date2 = dateFormat.parse(dateEnd);
            Date todayZeroTime= dateFormat.parse(dateFormat.format(new Date()));

            return (date1.compareTo(date2) <= 0 && date2.compareTo(todayZeroTime) >= 0);
        } catch (ParseException parseException){
            return false;
        }
    }
    public boolean validatePromotionAmount(double promotionAmount) {
        return (promotionAmount>=0);
    }
    public boolean validatePromotionPercent(double promotionPercent) {
        return (promotionPercent >= 0 && promotionPercent <= 100);
    }
    public void setCurrentPromotion(int promotionId) {
        for (Promotion promotion: promotions
             ) {
            if(promotion.getPromotionId() == promotionId) {
                currentPromotion = promotion;
            }
        }
    }
    public String getCurrentPromotionStartDate() {
        return currentPromotion.getPromotionDateStart();
    }

    public String getCurrentPromotionEndDate() {
        return currentPromotion.getPromotionDateEnd();
    }
    public void changePromotionName(String newPromotionName) {
        currentPromotion.setPromotionCode(newPromotionName);
    }
    public void changePromotionStartDate(String newPromotionStartDate) {
        currentPromotion.setPromotionDateStart(newPromotionStartDate);
    }
    public void changePromotionEndDate(String newPromotionEndDate) {
        currentPromotion.setPromotionDateEnd(newPromotionEndDate);
    }
    public void changePromotionAmount(double newPromotionAmount) {
        currentPromotion.setPromotionAmount(newPromotionAmount);
    }
    public void changePromotionPercent(double newPromotionPercent) {
        currentPromotion.setPromotionPercent(newPromotionPercent);
    }
    public void removeCurrentPromotion(){
        promotions.remove(currentPromotion);
    }
    public void removeAllExpiredPromotion(){
        try {
            Date todayZeroTime= dateFormat.parse(dateFormat.format(new Date()));
//            for (Promotion promotion: promotions
//                 ) {
//               Date promotionEndDate = dateFormat.parse(promotion.getPromotionDateEnd());
//               if(promotionEndDate.compareTo(todayZeroTime) < 0) {
//                   promotions.remove(promotion);
//               }
//            }
            for (int i = 0; i < promotions.size(); i++) {
                Promotion currentPromotion = promotions.get(i);
                Date promotionEndDate = dateFormat.parse(currentPromotion.getPromotionDateEnd());
                if (promotionEndDate.compareTo(todayZeroTime) < 0) {
                    promotions.remove(currentPromotion);
                }
            }
        } catch (ParseException parseException){
            System.out.println(parseException.getMessage());
        }
    }
}
