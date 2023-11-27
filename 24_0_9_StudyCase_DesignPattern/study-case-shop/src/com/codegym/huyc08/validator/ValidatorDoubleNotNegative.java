package com.codegym.huyc08.validator;

public class ValidatorDoubleNotNegative implements Validator{
    private double inputDouble;

    public ValidatorDoubleNotNegative(double inputDouble) {
        this.inputDouble = inputDouble;
    }

    @Override
    public boolean isCheck() {
        if(inputDouble < 0) {
            return false;
        } else {
            return true;
        }
    }
}
