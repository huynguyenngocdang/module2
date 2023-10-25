package com.codegym.huy_c08.constants;

public interface Constants {
    String USER_FILE_PATH = "data/users.json";
    String ADMIN_FILE_PATH = "data/admins.json";
    String PRODUCT_FILE_PATH = "data/product.json";
    String PROMOTION_FILE_PATH = "data/promotion.json";
    String PURCHASE_ORDER_FILE_PATH = "data/purchaseOrder.json";

    String ADMIN_REGEX = "^[aA][dD][mM][iI][nN]_\\d{1,}$";
    String USER_REGEX = "^[a-zA-Z0-9]{3,}$";
    String PROMOTION_REGEX = "^KM[a-z|A-Z|0-9]{2,}$";

    String DATE_REGEX = "^\\d{2}/\\d{2}/\\d{4}$";
    String DATE_PATTERN_REGEX = "dd/MM/yyyy";
    double PERCENT =  0.01;
    boolean isUserActiveTrue = true;
    boolean isUserActiveFalse = false;
    int USER_CHOICE_EXIT = 0;
    int USER_CHOICE_INIT = -1;
    int USER_CHOICE_1 = 1;
    int USER_CHOICE_2  = 2;
    int USER_CHOICE_3 = 3;
    int USER_CHOICE_4 = 4;
    int USER_CHOICE_5 = 5;
    int USER_CHOICE_6 = 6;
    int USER_CHOICE_7 = 7;
    int USER_CHOICE_8 = 8;
    int USER_CHOICE_9 = 9;
    int USER_CHOICE_10 = 10;
    int USER_CHOICE_11 = 11;
    int USER_CHOICE_99 = 99;
    String HR = "--------------";
    String USER_CHOICE_CONFIRM = "y";
}
