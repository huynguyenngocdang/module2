package com.codegym.huy_c08.entity;

import java.util.List;

public interface PromotionProgram {
    Promotion createPromotionProgram(int promotionId, String promotionCode, String promotionDateStart, String promotionDateEnd, double promotionAmount, double promotionPercent);


}
