package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.Constants;
import com.codegym.huyc08.entity.PurchaseOrder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StrategyReportWeeklyProfit implements StrategyReport {
    private List<PurchaseOrder> purchaseOrders;
    private double totalProfit;
   private double quantity;
   private String previousWeekString;
    private DateTimeFormatter dateTimeFormatter;


    public StrategyReportWeeklyProfit() {
        this.purchaseOrders = SingletonListPurchaseOrder.getInstance().getPurchaseOrders();
        this.totalProfit = 0;
        this.quantity = 0;
        this.dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.DATE_PATTERN_REGEX);
        LocalDate today = LocalDate.now();
        LocalDate previous = today.minusWeeks(1).atStartOfDay().toLocalDate();
        this.previousWeekString = previous.format(dateTimeFormatter);
    }

    @Override
    public void generateReport(int userId) {
        getReportData(userId);
        System.out.printf("Within a week you have sold %.2f items and gain %.2f profit \n",this.quantity, this.totalProfit );
    }

    private void getReportData(int userId) {
        for (PurchaseOrder po: purchaseOrders
             ) {
                if(po.getSellerId() == userId && isWithinWeek(po.getOrderDate())) {
                    totalProfit += po.getTotalCostAfterPromotion();
                    quantity += po.getQuantity();
                }
        }
    }

    private boolean isWithinWeek(String dateCreated){
        Validator validator = new ValidatorDateBeforeDate(previousWeekString, dateCreated);
        return validator.isCheck();
    }
}
