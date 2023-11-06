package com.codegym.huyc08.constant;

public interface Constants {
    String USER_FILE_PATH = "data/user.json";
    String ADMIN_FILE_PATH = "data/admin.json";
    String PROMOTION_FILE_PATH = "data/promotion.json";
    String ADMIN_REGEX = "^[aA][dD][mM][iI][nN]_\\d{1,}$";
    String USER_REGEX = "^[a-zA-Z0-9]{3,}$";
    String PROMOTION_REGEX = "^KM[a-z|A-Z|0-9]{2,}$";

    String DATE_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    String DATE_PATTERN_REGEX = "dd/MM/yyyy";
    int USER_EXIT_CHOICE = 0;
    int MAX_LOGIN_ATTEMPT = 3;
    String USER_CONFIRM = "y";
    String USER_REJECT = "n";
}
