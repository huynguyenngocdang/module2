package com.codegym.shop.Entity;

public interface UserInterface {

     default String getUserName() {

        return null;
    }
     default void setUserName(String userName) {

    }

     default String getUserPassword() {
        return null;
    }

     default void setUserPassword(String userPassword) {

    }

     default String getUserType() {
        return null;
    }

     default void setUserType(String userType) {

    }

    default boolean isCanCreateUser() {
       return false;
    }

     default void setCanCreateUser(boolean canCreateUser) {

    }

     default boolean isCanDeleteUser() {
         return false;
     }

     default void setCanDeleteUser(boolean canDeleteUser) {

    }

    default boolean isCanCreateProduct() {
        return false;
    }

    default void setCanCreateProduct(boolean canCreateProduct) {

    }

    default boolean isCanChangeProduct() {
        return false;
    }

    default void setCanChangeProduct(boolean canChangeProduct) {

    }

    default boolean isCanDeleteProduct() {
        return false;
    }

    default void setCanDeleteProduct(boolean canDeleteProduct) {

    }

    default boolean isCanBuyProduct() {
        return false;
    }

    default void setCanBuyProduct(boolean canBuyProduct) {

    }
}
