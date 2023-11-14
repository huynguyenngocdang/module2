package com.codegym.huyc08.service;

public class CommandGenerateWeeklyProfitReport implements Command{
    @Override
    public void execute() {
        StrategyReport weeklyReport = new StrategyReportWeeklyProfit();
        weeklyReport.generateReport(SingletonCurrentUser.getInstance().getCurrentUser().getUserId());
    }
}
