package com.codegym.huyc08.service;

public class CommandGenerateMonthlyCostReport implements Command{
    @Override
    public void execute() {
        StrategyReport report = new StrategyReportMonthlyCost();
        report.generateReport(SingletonCurrentUser.getInstance().getCurrentUser().getUserId());
    }
}
