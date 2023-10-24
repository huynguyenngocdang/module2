package com.codegym.huy_c08.menu;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.Product;
import com.codegym.huy_c08.entity.Promotion;
import com.codegym.huy_c08.service.AdminService;
import com.codegym.huy_c08.service.NormalUserService;
import com.codegym.huy_c08.service.ProductService;
import com.codegym.huy_c08.service.PromotionService;

import java.text.ParseException;
import java.util.Scanner;

public class Navigation {
    public Navigation() {
    }

    private final MenuMain menuMain = new MenuMain();
    private final MenuConsole menuConsole = new MenuConsole();
    private static final Scanner SCANNER = new Scanner(System.in);
    private final AdminService adminService = new AdminService();
    private final NormalUserService normalUserService = new NormalUserService();

    private final ProductService productService = new ProductService();
    private final PromotionService promotionService = new PromotionService();
    private Product currentProduct;

    public void navigationLogin() {
        int userChoice = Constants.USER_CHOICE_INIT;
        while (userChoice != Constants.USER_CHOICE_EXIT) {
            menuMain.menuLogin();
            adminService.refresh();
            userChoice = SCANNER.nextInt();
            switch (userChoice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Menu login");
                    break;
                case Constants.USER_CHOICE_1:
                    menuConsole.printUserInput("username");
                    String usernameLogin = SCANNER.next();
                    menuConsole.printUserInput("password");
                    String userPasswordLogin = SCANNER.next();
                    if (adminService.isLikeAdmin(usernameLogin)) {
                        adminService.logIn(usernameLogin, userPasswordLogin);
                        navigationAdminMenu();
                    } else {
                        if (normalUserService.isUserLoginCorrect(usernameLogin, userPasswordLogin)) {
                            normalUserService.logIn(usernameLogin, userPasswordLogin);
                            navigationUserMenu();
                        } else {
                            System.out.println("Wrong password");
                        }
                    }
                    break;
                case Constants.USER_CHOICE_2:
                    menuConsole.printUserInput("new username");
                    String usernameCreate = SCANNER.next();
                    if (normalUserService.isUserExist(usernameCreate)) {
                        System.out.println("User already exists");
                        break;
                    } else {
                        menuConsole.printUserInput("new password");
                        String userPasswordCreate = SCANNER.next();
                        normalUserService.userCreate(usernameCreate, userPasswordCreate);
                    }
                    break;
                case Constants.USER_CHOICE_99:
                    adminService.getAllUserAndAdminInformation();
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationUserMenu() {
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            normalUserService.getCurrentUserInformation();
            menuConsole.printHorizontalRule();
            menuMain.menuUser();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Main Menu");
                    break;
                case Constants.USER_CHOICE_1:
                    navigationUserProfile();
                    break;
                case Constants.USER_CHOICE_2:
                    navigationShopProfile();
                    break;
                case Constants.USER_CHOICE_3:
                    navigationShop();
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }

    }

    private void navigationUserProfile() {
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            normalUserService.getCurrentUserInformation();
            menuMain.menuUserProfile();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("User Profile");
                    break;
                case Constants.USER_CHOICE_1:
                    normalUserService.getCurrentUserInformation();
                    break;
                case Constants.USER_CHOICE_2:
                    menuConsole.printUserInput("new username");
                    String newUsername = SCANNER.next();
                    normalUserService.changeUserName(newUsername);
                    normalUserService.updateUsers();
                    navigationLogin();
                    break;
                case Constants.USER_CHOICE_3:
                    menuConsole.printUserInput("new password");
                    String newUserPassword = SCANNER.next();
                    normalUserService.changeUserPassword(newUserPassword);
                    normalUserService.updateUsers();
                    navigationLogin();
                    break;
                case Constants.USER_CHOICE_4:
                    menuConsole.printUserInput("new amount");
                    double newAmount = SCANNER.nextDouble();
                    normalUserService.changeUserAmount(newAmount);
                    normalUserService.updateUsers();
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationShopProfile() {
        int choice = Constants.USER_CHOICE_INIT;
        final int currentUserId = normalUserService.getCurrentUserId();
        while (choice != Constants.USER_CHOICE_EXIT) {
            normalUserService.getCurrentUserInformation();
            menuMain.menuUserShopDetail();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Shop profile");
                    break;
                case Constants.USER_CHOICE_1:
                    normalUserService.getCurrentUserCash();
                    break;
                case Constants.USER_CHOICE_2:
                    productService.getCurrentUserProductList(currentUserId);
                    break;
                case Constants.USER_CHOICE_3:
                    int newProductId = productService.getNewProductId();
                    int newProductSellerId = normalUserService.getCurrentUserId();
                    menuConsole.printUserInput("new product name");
                    String newProductName = SCANNER.next();
                    menuConsole.printUserInput("new product type");
                    String newProductType = SCANNER.next();
                    menuConsole.printUserInput("new product price");
                    double newProductPrice = SCANNER.nextDouble();
                    menuConsole.printUserInput("new product quantity");
                    double newProductQuantity = SCANNER.nextDouble();
                    menuConsole.printUserInput("new product manufacturer");
                    String newProductManufacturer = SCANNER.next();
                    menuConsole.printUserInput("new product description");
                    String newProductDescription = productService.inputLongDescription();
                    menuConsole.confirmNewProduct(newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
                    String confirm = SCANNER.next().toLowerCase();
                    if (confirm.equals(Constants.USER_CHOICE_CONFIRM)) {
                        double cashToCreate = newProductPrice * newProductQuantity;
                        if (normalUserService.isEnoughUserCash(cashToCreate)) {
                            productService.createNewProduct(newProductId, newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
                            normalUserService.updateUserNewCash(cashToCreate);
                        } else {
                            System.out.println("User don't have enough cash to create");
                        }
                    }
                    break;
                case Constants.USER_CHOICE_4:
                    menuConsole.printUserInput("your product id");
                    int productId = SCANNER.nextInt();
                    if (productService.isProductBelongToUser(productId, currentUserId)) {
                        currentProduct = productService.getProductCurrentUser(productId, currentUserId);
                        navigationMenuUserProductChange();
                    } else {
                        System.out.println("You does not own this product");
                    }
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationMenuUserProductChange() {
        double newProductPrice;
        double newProductQuantity;
        double currentProductPrice;
        double currentProductQuantity;
        double priceChange;
        double currentUserCash;
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            menuConsole.printCurrentProductHeader();
            System.out.println(currentProduct.toString());
            menuMain.menuUserShopChangeProduct();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Change product menu");
                    break;
                case Constants.USER_CHOICE_1:
                    menuConsole.printUserInput("new product name");
                    String newProductName = SCANNER.next();
                    productService.changeProductName(newProductName);

                    break;
                case Constants.USER_CHOICE_2:
                    menuConsole.printUserInput("new product type");
                    String newProductType = SCANNER.next();
                    productService.changeProductType(newProductType);

                    break;
                case Constants.USER_CHOICE_3:
                    menuConsole.printUserInput("new product price");
                    newProductPrice = SCANNER.nextDouble();
                    currentProductPrice = productService.getCurrentProductPrice();
                    currentProductQuantity = productService.getCurrentProductQuantity();
                    priceChange = productService.getPriceChange(newProductPrice, currentProductQuantity, currentProductPrice);
                    currentUserCash = normalUserService.getCurrentUserBalance();
                    menuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmChangePrice = SCANNER.next().toLowerCase();
                    if (confirmChangePrice.equals(Constants.USER_CHOICE_CONFIRM)) {
                        if (normalUserService.isEnoughUserCash(priceChange)) {
                            productService.changeProductPrice(newProductPrice);
                            normalUserService.updateUserNewCash(priceChange);
                        } else {
                            menuConsole.notEnoughCash("to change product price");
                        }
                    }
                    break;
                case Constants.USER_CHOICE_4:
                    menuConsole.printUserInput("new product quantity");
                    newProductQuantity = SCANNER.nextDouble();
                    currentProductPrice = productService.getCurrentProductPrice();
                    currentProductQuantity = productService.getCurrentProductQuantity();
                    priceChange = productService.getPriceChange(newProductQuantity, currentProductQuantity, currentProductPrice);
                    currentUserCash = normalUserService.getCurrentUserBalance();
                    menuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmChangeQuantity = SCANNER.next().toLowerCase();
                    if (confirmChangeQuantity.equals(Constants.USER_CHOICE_CONFIRM)) {
                        if (normalUserService.isEnoughUserCash(priceChange)) {
                            productService.changeProductQuantity(newProductQuantity);
                            normalUserService.updateUserNewCash(priceChange);
                        } else {
                            menuConsole.notEnoughCash("to change product quantity");
                        }
                    }
                    break;
                case Constants.USER_CHOICE_5:
                    menuConsole.printUserInput("new product manufacturer");
                    String newProductManufacturer = SCANNER.next();
                    productService.changeProductManufacturer(newProductManufacturer);
                    break;
                case Constants.USER_CHOICE_6:
                    menuConsole.printUserInput("new product description");
                    String newProductDescription = productService.inputLongDescription();
                    productService.changeProductDescription(newProductDescription);
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationShop() {
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            menuMain.menuUserShop();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Shop menu");
                    break;
                case Constants.USER_CHOICE_1:
                    productService.printAllProduct();
                    break;
                case Constants.USER_CHOICE_2:
                    productService.printAllProduct();
                    menuConsole.printUserInput("seller id you want to buy from");
                    int sellerId = SCANNER.nextInt();
                    menuConsole.printUserInput("product id you want to buy");

                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationAdminMenu() {
        int choice = Constants.USER_CHOICE_INIT;
        int userid;
        while (choice != Constants.USER_CHOICE_EXIT) {
            adminService.getCurrentUserInformation();
            menuConsole.printHorizontalRule();
            menuMain.menuAdmin();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Admin Menu");
                    break;
                case Constants.USER_CHOICE_1:
                    adminService.getCurrentUserInformation();
                    break;
                case Constants.USER_CHOICE_2:
                    adminService.getAllUserAndAdminInformation();
                    break;
                case Constants.USER_CHOICE_3:
                    menuConsole.printUserInput("user id");
                    userid = SCANNER.nextInt();
                    if (adminService.isUserExist(userid)) {
                        adminService.getSelectedUser(userid);
                        adminService.getCurrentUserInformation();
                    }
                    break;
                case Constants.USER_CHOICE_4:
                    menuConsole.printUserInput("user id");
                    userid = SCANNER.nextInt();
                    if (adminService.isUserExist(userid)) {
                        adminService.getSelectedUser(userid);
                        menuConsole.printUserInput("new user name");
                        String newUsername = SCANNER.next();
                        adminService.changeSelectedUserName(newUsername);
                        adminService.updateUsers();
                    } else {
                        menuConsole.printTypeDoesNotExist("user");
                    }
                    break;
                case Constants.USER_CHOICE_5:
                    menuConsole.printUserInput("user id");
                    userid = SCANNER.nextInt();
                    if (adminService.isUserExist(userid)) {
                        adminService.getSelectedUser(userid);
                        menuConsole.printUserInput("new user password");
                        String newUserPassword = SCANNER.next();
                        adminService.changeSelectedUserPassword(newUserPassword);
                        adminService.updateUsers();
                    } else {
                        menuConsole.printTypeDoesNotExist("user");
                    }
                case Constants.USER_CHOICE_6:
                    menuConsole.printUserInput("user id");
                    userid = SCANNER.nextInt();
                    if (adminService.isUserExist(userid)) {
                        adminService.getSelectedUser(userid);
                        adminService.getSelectedUserStatus();
                        menuConsole.printConfirm("change this user status");
                        String confirmChange = SCANNER.next().toLowerCase();
                        if (confirmChange.equals("y")) {
                            adminService.changeSelectedUserStatus();
                            adminService.updateUsers();
                        } else {
                            menuConsole.printDoesNotChange("this user status");
                        }
                    } else {
                        menuConsole.printTypeDoesNotExist("user");
                    }
                    break;
                case Constants.USER_CHOICE_7:
                    menuConsole.printUserInput("user id");
                    userid = SCANNER.nextInt();
                    if (adminService.isUserExist(userid)) {
                        adminService.getSelectedUser(userid);
                        adminService.getCurrentUserInformation();
                        menuConsole.printConfirm("delete this user");
                        String confirmChange = SCANNER.next().toLowerCase();
                        if (confirmChange.equals("y")) {
                            adminService.removeSelectedUser();
                            adminService.updateUsers();
                        } else {
                            menuConsole.printDoesNotChange("this user removal");
                        }
                    } else {
                        menuConsole.printTypeDoesNotExist("user");
                    }
                    break;
                case Constants.USER_CHOICE_8:
                    menuConsole.printUserInput("username");
                    String newUsername = SCANNER.next();
                    if (adminService.isLikeAdmin(newUsername)) {
                        menuConsole.printUserInput("password");
                        String newUserPassword = SCANNER.next();
                        adminService.userCreate(newUsername, newUserPassword);
                    } else {
                        System.out.println("admin user must start as admin_ + number");
                    }
                    break;
                case Constants.USER_CHOICE_9:
                    navigationMenuPromotionManage();
                    break;
                default:
                    menuConsole.printInvalidInput();
                    break;
            }
        }
    }

    private void navigationMenuPromotionManage() {
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            menuMain.menuPromotionManage();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Promotion program");
                    break;
                case Constants.USER_CHOICE_1:
                    promotionService.getAllPromotion();
                    break;
                case Constants.USER_CHOICE_2:
                    int newPromotionId = promotionService.getNewId();
                    menuConsole.printUserInput("new promotion name");
                    String newPromotionName = SCANNER.next();
                    if (promotionService.validatePromotionName(newPromotionName)) {
                        if (!promotionService.isPromotionExist(newPromotionName)) {
                            menuConsole.printUserInput("promotion start date (dd/MM/yyyy)");
                            String newPromotionStartDate = SCANNER.next();
                            if (promotionService.dateMatch(newPromotionStartDate)) {
                                menuConsole.printUserInput("promotion end date (dd/MM/yyyy)");
                                String newPromotionEndDate = SCANNER.next();
                                if (promotionService.dateMatch(newPromotionEndDate) && promotionService.dateCorrect(newPromotionStartDate, newPromotionEndDate)) {
                                    menuConsole.printUserInput("promotion amount");
                                    double newPromotionAmount = SCANNER.nextDouble();
                                    if (promotionService.validatePromotionAmount(newPromotionAmount)) {
                                        menuConsole.printUserInput("promotion percent(0-100)");
                                        double newPromotionPercent = SCANNER.nextDouble();
                                        if (promotionService.validatePromotionPercent(newPromotionPercent)) {
                                            Promotion newPromotion = new Promotion(newPromotionId, newPromotionName, newPromotionStartDate, newPromotionEndDate, newPromotionAmount, newPromotionPercent);
                                            promotionService.addPromotionToList(newPromotion);
                                            promotionService.savePromotion();
                                        } else {
                                            menuConsole.printInvalidInput("promotion percent");
                                        }
                                    } else {
                                        menuConsole.printInvalidInput("promotion amount");
                                    }
                                } else {
                                    menuConsole.printInvalidInput("promotion end date");
                                }
                            } else {
                                menuConsole.printInvalidInput("promotion start date");
                            }
                        } else {
                            menuConsole.printTypeAlreadyExist("promotion name");
                        }
                    } else {
                        menuConsole.printInvalidInput(",promotion name should start with KM and at lease 2 number");
                    }
                    break;
                case Constants.USER_CHOICE_3:
                    menuConsole.printUserInput("promotion id");
                    int selectedPromotionId = SCANNER.nextInt();
                    if (promotionService.isPromotionExist(selectedPromotionId)) {
                        promotionService.setCurrentPromotion(selectedPromotionId);
                        navigationMenuPromotionChange();
                    } else {
                        menuConsole.printInvalidInput();
                    }
                    break;
                default:
                    menuConsole.printInvalidInput("choice");
                    break;
            }
        }
    }

    public void navigationMenuPromotionChange() {
        int choice = Constants.USER_CHOICE_INIT;
        while (choice != Constants.USER_CHOICE_EXIT) {
            menuMain.menuPromotionChange();
            choice = SCANNER.nextInt();
            switch (choice) {
                case Constants.USER_CHOICE_EXIT:
                    menuConsole.printExitMenu("Change current promotion");
                    break;
                case Constants.USER_CHOICE_1:
                    menuConsole.printUserInput("new promotion name");
                    String newPromotionName = SCANNER.next();
                    if (promotionService.isPromotionExist(newPromotionName)) {
                        menuConsole.printTypeAlreadyExist("promotion");
                    } else {
                        if (promotionService.validatePromotionName(newPromotionName)) {
                            promotionService.changePromotionName(newPromotionName);
                            promotionService.savePromotion();
                        } else {
                            menuConsole.printInvalidInput(",promotion name should start with KM and at lease 2 number");
                        }
                    }
                    break;
                case Constants.USER_CHOICE_2:
                    menuConsole.printUserInput("new promotion start date(dd/MM/yyyy)");
                    String newPromotionStartDate = SCANNER.next();
                    String currentPromotionEndDate = promotionService.getCurrentPromotionEndDate();
                    if (promotionService.dateMatch(newPromotionStartDate) && promotionService.dateCorrect(newPromotionStartDate, currentPromotionEndDate)) {
                        promotionService.changePromotionStartDate(newPromotionStartDate);
                        promotionService.savePromotion();
                    } else {
                        menuConsole.printInvalidInput("promotion start date");
                    }
                    break;
                case Constants.USER_CHOICE_3:
                    menuConsole.printUserInput("new promotion start date(dd/MM/yyyy)");
                    String newPromotionEndDate = SCANNER.next();
                    String currentPromotionStartDate = promotionService.getCurrentPromotionStartDate();
                    if (promotionService.dateMatch(newPromotionEndDate) && promotionService.dateCorrect(currentPromotionStartDate, newPromotionEndDate)) {
                        promotionService.changePromotionEndDate(newPromotionEndDate);
                    } else {
                        menuConsole.printInvalidInput("promotion end date");
                    }
                    break;
                default:
                    menuConsole.printInvalidInput("choice");
                    break;
            }
        }
    }

}
