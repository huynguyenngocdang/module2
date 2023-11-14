package com.codegym.huyc08.service;

public class CommandGenerateWeeklyCostReport implements Command{
    @Override
    public void execute() {
        StrategyReport report = new StrategyReportWeeklyCost();
        report.generateReport(SingletonCurrentUser.getInstance().getCurrentUser().getUserId());
    }
}
