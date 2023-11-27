package com.codegym.huyc08.service;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.validator.Validator;
import com.codegym.huyc08.validator.ValidatorDateBeforeDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StrategyReportWeeklyCost implements StrategyReport{
    private List<PurchaseOrder> purchaseOrders;
    private double totalCost;
    private double totalQuantity;
    private DateTimeFormatter dateTimeFormatter;
    private String previousWeek;

    public StrategyReportWeeklyCost(){
        this.purchaseOrders = SingletonListPurchaseOrder.getInstance().getPurchaseOrders();
        this.totalCost = 0;
        this.totalQuantity = 0;
        dateTimeFormatter = DateTimeFormatter.ofPattern(AppConstant.DATE_PATTERN_REGEX);
        LocalDate now = LocalDate.now();
        LocalDate previous = now.minusWeeks(1).atStartOfDay().toLocalDate();
        this.previousWeek = previous.format(dateTimeFormatter);
    }
    @Override
    public void generateReport(int userId) {
        generateReportData(userId);
        System.out.printf("Within a week you have bought %.2f items and spend %.2f \n", totalQuantity, totalCost);
    }

    private void generateReportData(int userId) {
        for (PurchaseOrder po: purchaseOrders
             ) {
            if(po.getCustomerId() == userId && isWithinWeek(po.getOrderDate())) {
                totalQuantity += po.getQuantity();
                totalCost += po.getTotalCostAfterPromotion();
            }
        }
    }

    private boolean isWithinWeek(String dateCreated) {
        Validator validator = new ValidatorDateBeforeDate(previousWeek, dateCreated);
        return validator.isCheck();
    }
}
