package com.codegym.HuyC08.Menu;

import com.codegym.HuyC08.Entity.User;
import com.codegym.HuyC08.Service.ProductService;
import com.codegym.HuyC08.Service.UserService;

import java.util.Scanner;

public class Navigation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void navigationMenuLogin() {
        UserService.llUser = UserService.userFileRead();
        int choice = -1;
        int wrongPasswordCount = 0;
        while (choice!= 0 && wrongPasswordCount <= UserService.wrongPasswordCountAttempt) {
            MenuMain.menuLogin();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (wrongPasswordCount == UserService.wrongPasswordCountAttempt - 1) {
                        MenuConsole.wrongPasswordEnterFinal(wrongPasswordCount);
                    }
                    MenuConsole.inputUser("username");
                    String name = scanner.next();
                    MenuConsole.inputUser("password");
                    String password = scanner.next();
                    if(UserService.isUserExist(name)) {
                        UserService.getCurrentUser(name);
                        if (UserService.isUserPasswordCorrect(password)){
                            MenuConsole.loggingInSuccessful();
                            navigationMenuUser();
                        } else {
                            wrongPasswordCount +=1;
                            MenuConsole.wrongPasswordEnter(wrongPasswordCount);
                        }
                    } else {
                        MenuConsole.noExistUserDatabase();
                    }
                    break;
                case 2:

                    MenuConsole.inputUser("new username");
                    String newUserName = scanner.next();
                    if (UserService.isUserExist(newUserName)) {
                        MenuConsole.existUserDatabase();
                        break;
                    }

                    MenuConsole.inputUser("new password");
                    String newUserPassword = scanner.next();
                    int newId = UserService.getNewUserId();
                    UserService.createNewUser(newId, newUserName, newUserPassword);
                    break;
                case 99:
                    for (User user: UserService.llUser) {
                        System.out.println(user.toString());
                    }
                    break;
                case 0:
                    MenuConsole.exiting();
                    System.exit(0);
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
        MenuConsole.exiting();
        System.exit(0);
    }

    private static void navigationMenuUser() {
        int choice = -1;
        while (choice!= 0) {
            System.out.println("Welcome " + UserService.currUser.getUserName() );
            MenuMain.menuUser();
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    MenuConsole.exiting();
                    navigationMenuLogin();
                    break;
                case 1:
                    navigationMenuUserProfile();
                    break;
                case 2:
                    navigationMenuUserShopDetail();
                    break;
                case 3:
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }

    private static void navigationMenuUserProfile() {
        int choice = -1;
        while (choice!= 0) {
            System.out.println("Welcome " + UserService.currUser.getUserName() );
            MenuMain.menuUserDetail();
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    MenuConsole.exiting();
                    break;
                case 1:
                    System.out.println(UserService.currUser.toString());
                    break;
                case 2:
//                    System.out.println("Your current username is " + UserService.currUser.getUserName());
                    MenuConsole.currentUserData("username", UserService.currUser.getUserName());

                    MenuConsole.inputUser("new username");
                    String newUserName = scanner.next();
                    if (UserService.isUserExist(newUserName)) {
                        MenuConsole.existUserDatabase();
                    } else {
                        UserService.updateUserNewName(newUserName);
                        navigationMenuLogin();
                    }
                    navigationMenuUserProfile();
                    break;
                case 3:
//                    System.out.println("Your current password is " + UserService.currUser.getUserPassword());
                    MenuConsole.currentUserData("password", UserService.currUser.getUserPassword());

                    MenuConsole.inputUser("new password");
                    String newUserPassword = scanner.next();
                    UserService.updateUserNewPassword(newUserPassword);
                    navigationMenuLogin();
                    break;
                case 4:
//                    System.out.println("Your current cash is " + UserService.currUser.getUserCash());
                    MenuConsole.currentUserData("cash", UserService.currUser.getUserCash());
                    double currentCash = UserService.currUser.getUserCash();
                    MenuConsole.inputNewCash();
                    double newCash = scanner.nextDouble() + currentCash;
                    UserService.updateUserNewCash(newCash);
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;

            }
        }
    }

    private static void navigationMenuUserShopDetail() {
        int choice = -1;
        while (choice != 0) {
            MenuMain.menuUserShopDetail();
            choice = scanner.nextInt();
            switch (choice){
                case 0:
                    MenuConsole.exiting();
                    navigationMenuUser();
                    break;
                case 1:
                    MenuConsole.currentUserData("cash", UserService.currUser.getUserCash());
                    break;
                case 2:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    break;
                case 3:
                    ProductService.llProduct = ProductService.productFileRead();
                    int newProductId = ProductService.getNewProductId();
                    int newProductSellerId = UserService.currUser.getId();
                    MenuConsole.inputUser("new product name");
                    String newProductName = scanner.next();
                    MenuConsole.inputUser("new product type");
                    String newProductType = scanner.next();
                    MenuConsole.inputUser("new product price");
                    double newProductPrice = scanner.nextDouble();
                    MenuConsole.inputUser("new product quantity");
                    double newProductQuantity = scanner.nextDouble();
                    MenuConsole.inputUser("new product manufacturer");
                    String newProductManufacturer = scanner.next();
                    MenuConsole.inputUser("new product description");
                    String newProductDescription = ProductService.inputLongDescription();
                    MenuConsole.confirmNewProduct(newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
                    String confirm = scanner.next().toLowerCase();
                    if (confirm.equals("y")) {
                       double cashToCreate = newProductPrice * newProductQuantity;
                       if (ProductService.isEnoughUserCash(cashToCreate)) {
                           ProductService.createNewProduct(newProductId, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
                           double currUserCash = UserService.currUser.getUserCash();
                            UserService.updateUserNewCash(currUserCash - cashToCreate);
                       } else {
                           MenuConsole.notEnoughCash("to create new item");
                       }
                    }
                    break;
                case 4:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    MenuConsole.inputUser("your product id");
                    int productId = scanner.nextInt();
                    ProductService.getCurrentProduct(productId, UserService.currUser.getId());
                    navigationMenuUserProductChange(productId);
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }

    }
    private static void navigationMenuUserProductChange(int productId) {
        double newProductPrice;
        double newProductQuantity;
        double currentProductPrice;
        double currentProductQuantity;
        double newTotalPrice;
        double originTotalPrice;
        double priceChange;
        double currentUserCash;
        int choice = -1;
        while (choice!=0) {
            MenuMain.menuUserShopChangeProduct();
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    MenuConsole.exiting();
                    break;
                case 1:
                    MenuConsole.currentUserData("product name", ProductService.productCurrentUser.getProductName());
                    MenuConsole.inputUser("new product name");
                    String newProductName = scanner.next();
                    ProductService.llProduct.remove(ProductService.productCurrentUser);
                    ProductService.productCurrentUser.setProductName(newProductName);
                    ProductService.llProduct.add(ProductService.productCurrentUser);
                    ProductService.sortProductLinkedList();
                    ProductService.productFileWrite(ProductService.llProduct);
                    break;
                case 2:
                    MenuConsole.currentUserData("product type", ProductService.productCurrentUser.getProductType());
                    MenuConsole.inputUser("new product type");
                    String newProductType = scanner.next();
                    ProductService.llProduct.remove(ProductService.productCurrentUser);
                    ProductService.productCurrentUser.setProductType(newProductType);
                    ProductService.llProduct.add(ProductService.productCurrentUser);
                    ProductService.sortProductLinkedList();
                    ProductService.productFileWrite(ProductService.llProduct);
                    break;
                case 3:
                    MenuConsole.currentUserData("product price", ProductService.productCurrentUser.getProductPrice());
                    MenuConsole.inputUser("new product price");
                     newProductPrice = scanner.nextDouble();
                     currentProductPrice =  ProductService.productCurrentUser.getProductPrice();
                     currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();
                     newTotalPrice = newProductPrice * currentProductQuantity;
                     originTotalPrice = currentProductPrice * currentProductQuantity;
                     priceChange = newTotalPrice - originTotalPrice;
                     currentUserCash = UserService.currUser.getUserCash();

                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmPriceChange = scanner.next().toLowerCase();
                    if (confirmPriceChange.equals("y")) {
                        if (ProductService.isEnoughUserCash(priceChange)) {
                            ProductService.llProduct.remove(ProductService.productCurrentUser);
                            ProductService.productCurrentUser.setProductPrice(newProductPrice);
                            ProductService.llProduct.add(ProductService.productCurrentUser);
                            ProductService.sortProductLinkedList();
                            ProductService.productFileWrite(ProductService.llProduct);

                            double currUserCash = UserService.currUser.getUserCash();
                            UserService.updateUserNewCash(currUserCash - priceChange);
                        } else {
                            MenuConsole.notEnoughCash("to change product price");
                        }
                    }
                    break;
                case 4:
                    MenuConsole.currentUserData("product quantity", ProductService.productCurrentUser.getProductQuantity());
                    MenuConsole.inputUser("new product quantity");
                    newProductQuantity = scanner.nextDouble();
                    currentProductPrice =  ProductService.productCurrentUser.getProductPrice();
                    currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();
                    newTotalPrice = currentProductPrice * newProductQuantity;
                    originTotalPrice = currentProductPrice * currentProductQuantity;
                    priceChange = newTotalPrice - originTotalPrice;
                    currentUserCash = UserService.currUser.getUserCash();
                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmQuantityChange = scanner.next().toLowerCase();
                    if (confirmQuantityChange.equals("y")) {
                        if (ProductService.isEnoughUserCash(priceChange)) {
                            ProductService.llProduct.remove(ProductService.productCurrentUser);
                            ProductService.productCurrentUser.setProductQuantity(newProductQuantity);
                            ProductService.llProduct.add(ProductService.productCurrentUser);
                            ProductService.sortProductLinkedList();
                            ProductService.productFileWrite(ProductService.llProduct);

                            double currUserCash = UserService.currUser.getUserCash();
                            UserService.updateUserNewCash(currUserCash - priceChange);
                        } else {
                            MenuConsole.notEnoughCash("to change product quantity");
                        }
                    }
                    break;
                case 5:
                    MenuConsole.currentUserData("product manufacturer", ProductService.productCurrentUser.getProductManufacturer());
                    MenuConsole.inputUser("new product manufacturer");
                    String newProductManuFacturer = scanner.next();
                    ProductService.llProduct.remove(ProductService.productCurrentUser);
                    ProductService.productCurrentUser.setProductManufacturer(newProductManuFacturer);
                    ProductService.llProduct.add(ProductService.productCurrentUser);
                    ProductService.sortProductLinkedList();
                    ProductService.productFileWrite(ProductService.llProduct);
                    break;
                case 6:
                    MenuConsole.currentUserData("product description", ProductService.productCurrentUser.getProductDescription());
                    MenuConsole.inputUser("new product description");
                    String newProductManuDescription = ProductService.inputLongDescription();
                    ProductService.llProduct.remove(ProductService.productCurrentUser);
                    ProductService.productCurrentUser.setProductDescription(newProductManuDescription);
                    ProductService.llProduct.add(ProductService.productCurrentUser);
                    ProductService.sortProductLinkedList();
                    ProductService.productFileWrite(ProductService.llProduct);
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }

    private static void navigationMenuUserShop() {
        int choice = -1;
        while (choice!=0) {
            MenuMain.menuUserShop();
            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    MenuConsole.exiting();
                    navigationMenuUser();
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }
}