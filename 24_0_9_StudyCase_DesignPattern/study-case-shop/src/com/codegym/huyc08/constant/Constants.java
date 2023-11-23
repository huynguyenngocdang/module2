package com.codegym.huyc08.constant;

public interface Constants {
    String USER_FILE_PATH = "data/user.json";
    String ADMIN_FILE_PATH = "data/admin.json";
    String PROMOTION_FILE_PATH = "data/promotion.json";
    String PRODUCT_FILE_PATH = "data/product.json";
    String PURCHASE_ORDER_FILE_PATH = "data/purchaseOrder.json";
    String MESSAGE_FILE_PATH = "data/message.json";
    String ADMIN_REGEX = "^[aA][dD][mM][iI][nN]_\\d{1,}$";
    String USER_REGEX = "^[a-zA-Z0-9]{3,}$";
    String PROMOTION_REGEX = "^KM[a-z|A-Z|0-9]{2,}$";
    String DATE_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    String SEARCH_REGEX = "\\w{0,}?\\d{0,}?\\s{0,}?";

    String DATE_PATTERN_REGEX = "dd/MM/yyyy";
    String FULL_DATE_PATTERN_REGEX = "dd/MM/yyyy,HH:mm:ss";

    int USER_EXIT_CHOICE = 0;
    int MAX_LOGIN_ATTEMPT = 3;
    String USER_CONFIRM = "Y";
    String USER_REJECT = "N";
    int ADMIN_ID = -1;
    double PERCENT =  0.01;
}
