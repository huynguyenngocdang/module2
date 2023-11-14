package com.codegym.huyc08.service;

public class CommandGenerateMontlyProfitReport implements Command{
    @Override
    public void execute() {
        StrategyReport report = new StrategyReportMonthlyProfit();
        report.generateReport(SingletonCurrentUser.getInstance().getCurrentUser().getUserId());
    }
}
