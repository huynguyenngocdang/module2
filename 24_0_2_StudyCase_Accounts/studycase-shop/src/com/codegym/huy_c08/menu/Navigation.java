package com.codegym.huy_c08.menu;

import com.codegym.huy_c08.entity.PurchaseOrder;
import com.codegym.huy_c08.entity.User;
import com.codegym.huy_c08.service.ProductService;
import com.codegym.huy_c08.service.PurchaseOrderService;
import com.codegym.huy_c08.service.UserService;

import java.util.Scanner;

public class Navigation {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final int CHOICE_QUIT = 0;
    private static final int CHOICE_99 = 99;
    private static final int CHOICE_1 = 1;
    private static final int CHOICE_2 = 2;
    private static final int CHOICE_3 = 3;
    private static final int CHOICE_4 = 4;
    private static final int CHOICE_5 = 5;
    private static final int CHOICE_6 = 6;
    private static final int CHOICE_7 = 7;
    private static final int CHOICE_8 = 8;
    private static final int CHOICE_9 = 9;


    public static void navigationMenuLogin() {
        UserService.llUser = UserService.userFileRead();
        int choice = -1;
        int wrongPasswordCount = 0;
        while (choice != CHOICE_QUIT && wrongPasswordCount < UserService.WRONG_PASSWORD_COUNT_ATTEMPT) {
            MenuMain.menuLogin();
            choice = SCANNER.nextInt();
            switch (choice) {
                //fix magic 1
                case CHOICE_1:
                    if (wrongPasswordCount == (UserService.WRONG_PASSWORD_COUNT_ATTEMPT - 1)) {
                        MenuConsole.wrongPasswordEnterFinal(wrongPasswordCount);
                    }
                    MenuConsole.inputUser("username");
                    String name = SCANNER.next();
                    MenuConsole.inputUser("password");
                    String password = SCANNER.next();
                    if (UserService.isUserExist(name)) {
                        UserService.getCurrentUser(name);
                        if (UserService.isUserPasswordCorrect(password)) {
                            MenuConsole.loggingInSuccessful();
                            navigationMenuUser();
                        } else {
                            wrongPasswordCount += 1;
                            MenuConsole.wrongPasswordEnter(wrongPasswordCount);
                        }
                    } else {
                        MenuConsole.noExistUserDatabase();
                    }
                    break;
                case CHOICE_2:

                    MenuConsole.inputUser("new username");
                    String newUserName = SCANNER.next();
                    if (UserService.isUserExist(newUserName)) {
                        MenuConsole.existUserDatabase();
                        break;
                    }

                    MenuConsole.inputUser("new password");
                    String newUserPassword = SCANNER.next();
                    int newId = UserService.getNewUserId();
                    UserService.createNewUser(newId, newUserName, newUserPassword);
                    break;
                case CHOICE_99:
                    for (User user : UserService.llUser) {
                        System.out.println(user.toString());
                    }
                    break;
                case CHOICE_QUIT:
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
        while (choice != CHOICE_QUIT) {
            System.out.println("Welcome " + UserService.currUser.getUserName());
            MenuMain.menuUser();
            choice = SCANNER.nextInt();
            switch (choice) {
                case CHOICE_QUIT:
                    MenuConsole.exiting();
                    navigationMenuLogin();
                    break;
                case CHOICE_1:
                    navigationMenuUserProfile();
                    break;
                case CHOICE_2:
                    navigationMenuUserShopDetail();
                    break;
                case CHOICE_3:
                    navigationMenuUserShop();
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }

    private static void navigationMenuUserProfile() {
        int choice = -1;
        while (choice != CHOICE_QUIT) {
            System.out.println("Welcome " + UserService.currUser.getUserName());
            MenuMain.menuUserDetail();
            choice = SCANNER.nextInt();
            switch (choice) {
                case CHOICE_QUIT:
                    MenuConsole.exiting();
                    break;
                case CHOICE_1:
                    System.out.println(UserService.currUser.toString());
                    break;
                case CHOICE_2:
                    MenuConsole.currentUserData("username", UserService.currUser.getUserName());

                    MenuConsole.inputUser("new username");
                    String newUserName = SCANNER.next();
                    if (UserService.isUserExist(newUserName)) {
                        MenuConsole.existUserDatabase();
                    } else {
                        UserService.updateUserNewName(newUserName);
                        navigationMenuLogin();
                    }
                    navigationMenuUserProfile();
                    break;
                case CHOICE_3:
                    MenuConsole.currentUserData("password", UserService.currUser.getUserPassword());
                    MenuConsole.inputUser("new password");
                    String newUserPassword = SCANNER.next();
                    UserService.updateUserNewPassword(newUserPassword);
                    navigationMenuLogin();
                    break;
                case CHOICE_4:
                    MenuConsole.currentUserData("cash", UserService.currUser.getUserCash());
                    double currentCash = UserService.currUser.getUserCash();
                    MenuConsole.inputNewCash();
                    double newCash = SCANNER.nextDouble() + currentCash;
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
        int productId;
        while (choice != CHOICE_QUIT) {
            MenuMain.menuUserShopDetail();
            ProductService.llProduct = ProductService.productFileRead();
            choice = SCANNER.nextInt();
            switch (choice) {
                case CHOICE_QUIT:
                    MenuConsole.exiting();
                    navigationMenuUser();
                    break;
                case CHOICE_1:
                    MenuConsole.currentUserData("cash", UserService.currUser.getUserCash());
                    break;
                case CHOICE_2:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    break;
                case CHOICE_3:

                    int newProductId = ProductService.getNewProductId();
                    int newProductSellerId = UserService.currUser.getId();
                    MenuConsole.inputUser("new product name");
                    String newProductName = SCANNER.next();
                    MenuConsole.inputUser("new product type");
                    String newProductType = SCANNER.next();
                    MenuConsole.inputUser("new product price");
                    double newProductPrice = SCANNER.nextDouble();
                    MenuConsole.inputUser("new product quantity");
                    double newProductQuantity = SCANNER.nextDouble();
                    MenuConsole.inputUser("new product manufacturer");
                    String newProductManufacturer = SCANNER.next();
                    MenuConsole.inputUser("new product description");
                    String newProductDescription = ProductService.inputLongDescription();
                    MenuConsole.confirmNewProduct(newProductSellerId, newProductName, newProductType, newProductPrice, newProductQuantity, newProductManufacturer, newProductDescription);
                    String confirm = SCANNER.next().toLowerCase();
                    //magic
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
                case CHOICE_4:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    MenuConsole.inputUser("your product id");
                    productId = SCANNER.nextInt();
                    if (ProductService.isProductBelongToUser(productId, UserService.currUser.getId())) {
                        ProductService.getCurrentProductUser(productId, UserService.currUser.getId());
                        navigationMenuUserProductChange();
                    } else {
                        System.out.println("You does not own this product");
                    }
                    break;
                case CHOICE_5:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    MenuConsole.inputUser("your product id");
                    productId = SCANNER.nextInt();
                    if (ProductService.isProductBelongToUser(productId, UserService.currUser.getId())) {
                        ProductService.getCurrentProductUser(productId, UserService.currUser.getId());
                        double currentProductPrice = ProductService.productCurrentUser.getProductPrice();
                        double currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();
                        double currentUserCash = UserService.currUser.getUserCash();
                        double priceChange = -(currentProductPrice * currentProductQuantity);
                        MenuConsole.changeProductPrice(priceChange, currentUserCash);
                        String confirmQuantityChange = SCANNER.next().toLowerCase();
                        if (confirmQuantityChange.equals("y")) {
                            if (ProductService.isEnoughUserCash(priceChange)) {
                                ProductService.llProduct.remove(ProductService.productCurrentUser);
                                ProductService.sortProductLinkedList();
                                ProductService.productFileWrite(ProductService.llProduct);
                                double currUserCash = UserService.currUser.getUserCash();
                                UserService.updateUserNewCash(currUserCash - priceChange);
                            } else {
                                MenuConsole.notEnoughCash("to change product quantity");
                            }
                        }

                    } else {
                        System.out.println("You does not own this product");
                    }
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }

    private static void navigationMenuUserProductChange() {
        double newProductPrice;
        double newProductQuantity;
        double currentProductPrice;
        double currentProductQuantity;
        double priceChange;
        double currentUserCash;
        int choice = -1;
        while (choice != CHOICE_QUIT) {
            MenuMain.menuUserShopChangeProduct();
            choice = SCANNER.nextInt();
            switch (choice) {
                case CHOICE_QUIT:
                    MenuConsole.exiting();
                    break;
                case CHOICE_1:
                    MenuConsole.currentUserData("product name", ProductService.productCurrentUser.getProductName());
                    MenuConsole.inputUser("new product name");
                    String newProductName = SCANNER.next();
                    ProductService.updateProductName(newProductName);
                    break;
                case CHOICE_2:
                    MenuConsole.currentUserData("product type", ProductService.productCurrentUser.getProductType());
                    MenuConsole.inputUser("new product type");
                    String newProductType = SCANNER.next();
                    ProductService.updateProductType(newProductType);
                    break;
                case CHOICE_3:
                    MenuConsole.currentUserData("product price", ProductService.productCurrentUser.getProductPrice());
                    MenuConsole.inputUser("new product price");
                    newProductPrice = SCANNER.nextDouble();

                    currentProductPrice = ProductService.productCurrentUser.getProductPrice();
                    currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();

                    priceChange = ProductService.getPriceChange(newProductPrice, currentProductQuantity, currentProductPrice);

                    currentUserCash = UserService.currUser.getUserCash();

                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmPriceChange = SCANNER.next().toLowerCase();
                    if (confirmPriceChange.equals("y")) {
                        if (ProductService.isEnoughUserCash(priceChange)) {
                            ProductService.updateProductPrice(newProductPrice);

                            double currUserCash = UserService.currUser.getUserCash();
                            UserService.updateUserNewCash(currUserCash - priceChange);
                        } else {
                            MenuConsole.notEnoughCash("to change product price");
                        }
                    }
                    break;
                case CHOICE_4:
                    MenuConsole.currentUserData("product quantity", ProductService.productCurrentUser.getProductQuantity());
                    MenuConsole.inputUser("new product quantity");
                    newProductQuantity = SCANNER.nextDouble();

                    currentProductPrice = ProductService.productCurrentUser.getProductPrice();
                    currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();

                    priceChange = ProductService.getPriceChange(newProductQuantity, currentProductPrice, currentProductQuantity);

                    currentUserCash = UserService.currUser.getUserCash();

                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmQuantityChange = SCANNER.next().toLowerCase();
                    if (confirmQuantityChange.equals("y")) {
                        if (ProductService.isEnoughUserCash(priceChange)) {
                            ProductService.updateProductQuantity(newProductQuantity);

                            double currUserCash = UserService.currUser.getUserCash();
                            UserService.updateUserNewCash(currUserCash - priceChange);
                        } else {
                            MenuConsole.notEnoughCash("to change product quantity");
                        }
                    }
                    break;
                case CHOICE_5:
                    MenuConsole.currentUserData("product manufacturer", ProductService.productCurrentUser.getProductManufacturer());
                    MenuConsole.inputUser("new product manufacturer");
                    String newProductManuFacturer = SCANNER.next();
                    ProductService.updateProductManufacturer(newProductManuFacturer);
                    break;
                case CHOICE_6:
                    MenuConsole.currentUserData("product description", ProductService.productCurrentUser.getProductDescription());
                    MenuConsole.inputUser("new product description");
                    String newProductManuDescription = ProductService.inputLongDescription();
                    ProductService.updateProductDescription(newProductManuDescription);
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }


    private static void navigationMenuUserShop() {
        int choice = -1;
        while (choice != CHOICE_QUIT) {
            MenuMain.menuUserShop();


            choice = SCANNER.nextInt();
            switch (choice) {
                case CHOICE_QUIT:
                    MenuConsole.exiting();
                    navigationMenuUser();
                    break;
                case CHOICE_1:
                    ProductService.printProductsAllUser();
                    break;
                case CHOICE_2:
                    ProductService.printProductsAllUser();
                    MenuConsole.inputUser("seller id you want to buy from");
                    int sellerId = SCANNER.nextInt();
                    MenuConsole.inputUser("product id you want to buy");
                    int productId = SCANNER.nextInt();
                    if (ProductService.isProductBelongSeller(productId, sellerId)) {
                        MenuConsole.inputUser("product quantity you want to buy");
                        int productQuantity = SCANNER.nextInt();
                        ProductService.getProductSeller(productId, sellerId);

                        //check if enough quantity
                        if (ProductService.isEnoughProductSeller(productQuantity)) {
                            int orderId = PurchaseOrderService.getNewPOId();
                            int customerId = UserService.currUser.getId();
                            double productPrice = ProductService.productCurrentSeller.getProductPrice();
                            double totalCost = productPrice * productQuantity;

                            String productName = ProductService.productCurrentSeller.getProductName();

                            UserService.getCurrentSeller(sellerId);

                            String sellerName = UserService.currSeller.getUserName();
                            double currentUserCash = UserService.currUser.getUserCash();
                            MenuConsole.confirmPurchaseProduct(sellerId, sellerName, productId, productName, productPrice, productQuantity, currentUserCash);
                            String confirmPurchase = SCANNER.next().toLowerCase();
                            //check if user confirm to buy
                            if (confirmPurchase.equals("y")) {
                                //check enough user cash
                                if (ProductService.isEnoughUserCash(totalCost)) {
                                    //create new po, add to poFile
                                    PurchaseOrder po = new PurchaseOrder(orderId, customerId, sellerId, productId, productPrice, productQuantity);
                                    PurchaseOrderService.llPurchaseOrders.add(po);
                                    PurchaseOrderService.purchaseOrderWrite(PurchaseOrderService.llPurchaseOrders);

                                    //update product
                                    double newProductQuantity = ProductService.productCurrentSeller.getProductQuantity() - productQuantity;
                                    ProductService.updateProductQuantity(newProductQuantity, ProductService.productCurrentSeller);

                                    //update seller
                                    double newSellerCash = UserService.currSeller.getUserCash() + totalCost;
                                    UserService.updateUserNewCash(newSellerCash, UserService.currSeller);

                                    //update buyer
                                    double newBuyerCash = UserService.currUser.getUserCash() - totalCost;
                                    UserService.updateUserNewCash(newBuyerCash, UserService.currUser);
                                } else {
                                    System.out.println("You don't have enough cash to make this purchase");
                                }
                            } else {
                                navigationMenuUserShop();
                                break;
                            }

                        } else {
                            System.out.println("There is not enough product to sell");
                        }

                    } else {
                        System.out.println("This seller doesn't sell the input product");
                    }
                    break;
                default:
                    MenuConsole.invalidInput();
                    break;
            }
        }
    }
}
