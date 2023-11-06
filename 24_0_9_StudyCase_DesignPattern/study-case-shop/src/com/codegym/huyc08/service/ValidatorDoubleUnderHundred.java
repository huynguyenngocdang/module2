package com.codegym.huyc08.service;

public class ValidatorDoubleUnderHundred implements Validator{
    private double inputDouble;

    public ValidatorDoubleUnderHundred(double inputDouble) {
        this.inputDouble = inputDouble;
    }

    @Override
    public boolean isCheck() {
        if(inputDouble <= 100) {
            return true;
        } else {
            return false;
        }
    }
}
