package com.codegym.shop.Entity;

public class User implements UserInterface, Cloneable {
    private String userName;
    private String userPassword;
    private String userType;

    private int currentCash;
    private  boolean canChangePermission;

    private boolean canCreateUser;
    private boolean canDeleteUser;
    private boolean canCreateProduct;
    private boolean canChangeProduct;
    private boolean canDeleteProduct;
    private boolean canBuyProduct;


    public User(String userName, String userPassword, String userType) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
    }

    public User(String userName, String userPassword, String userType, int currentCash, boolean canChangePermission, boolean canCreateUser, boolean canDeleteUser, boolean canCreateProduct, boolean canChangeProduct, boolean canDeleteProduct, boolean canBuyProduct) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.userType = userType;
        this.currentCash = currentCash;
        this.canChangePermission = canChangePermission;
        this.canCreateUser = canCreateUser;
        this.canDeleteUser = canDeleteUser;
        this.canCreateProduct = canCreateProduct;
        this.canChangeProduct = canChangeProduct;
        this.canDeleteProduct = canDeleteProduct;
        this.canBuyProduct = canBuyProduct;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
         this.userType = userType;
    }

    public int getCurrentCash() {
        return currentCash;
    }

    public void setCurrentCash(int currentCash) {
        this.currentCash = currentCash;
    }

    public boolean isCanChangePermission() {
        return canChangePermission;
    }

    public void setCanChangePermission(boolean canChangePermission) {
        this.canChangePermission = canChangePermission;
    }

    public boolean isCanCreateUser() {
        return canCreateUser;
    }

    public void setCanCreateUser(boolean canCreateUser) {
        this.canCreateUser = canCreateUser;
    }

    public boolean isCanDeleteUser() {
        return canDeleteUser;
    }

    public void setCanDeleteUser(boolean canDeleteUser) {
        this.canDeleteUser = canDeleteUser;
    }

    public boolean isCanCreateProduct() {
        return canCreateProduct;
    }

    public void setCanCreateProduct(boolean canCreateProduct) {
        this.canCreateProduct = canCreateProduct;
    }

    public boolean isCanChangeProduct() {
        return canChangeProduct;
    }

    public void setCanChangeProduct(boolean canChangeProduct) {
        this.canChangeProduct = canChangeProduct;
    }

    public boolean isCanDeleteProduct() {
        return canDeleteProduct;
    }

    public void setCanDeleteProduct(boolean canDeleteProduct) {
        this.canDeleteProduct = canDeleteProduct;
    }

    public boolean isCanBuyProduct() {
        return canBuyProduct;
    }

    public void setCanBuyProduct(boolean canBuyProduct) {
        this.canBuyProduct = canBuyProduct;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userType='" + userType + '\'' +
                ", currentCash=" + currentCash +
                ", canChangePermission=" + canChangePermission +
                ", canCreateUser=" + canCreateUser +
                ", canDeleteUser=" + canDeleteUser +
                ", canCreateProduct=" + canCreateProduct +
                ", canChangeProduct=" + canChangeProduct +
                ", canDeleteProduct=" + canDeleteProduct +
                ", canBuyProduct=" + canBuyProduct +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
