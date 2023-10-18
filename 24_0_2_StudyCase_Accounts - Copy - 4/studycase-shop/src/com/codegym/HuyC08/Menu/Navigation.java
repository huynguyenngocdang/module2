package com.codegym.HuyC08.Menu;

import com.codegym.HuyC08.Entity.PurchaseOrder;
import com.codegym.HuyC08.Entity.User;
import com.codegym.HuyC08.Service.ProductService;
import com.codegym.HuyC08.Service.PurchaseOrderService;
import com.codegym.HuyC08.Service.UserService;

import java.util.Scanner;

public class Navigation {
    private static final Scanner scanner = new Scanner(System.in);

    public static void navigationMenuLogin() {
        UserService.llUser = UserService.userFileRead();
        int choice = -1;
        int wrongPasswordCount = 0;
        while (choice!= 0 && wrongPasswordCount < UserService.wrongPasswordCountAttempt) {
            MenuMain.menuLogin();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (wrongPasswordCount == (UserService.wrongPasswordCountAttempt - 1)) {
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
        int productId;
        while (choice != 0) {
            MenuMain.menuUserShopDetail();
            ProductService.llProduct = ProductService.productFileRead();
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
                     productId = scanner.nextInt();
                    if (ProductService.isProductBelongToUser(productId, UserService.currUser.getId())) {
                        ProductService.getCurrentProductUser(productId, UserService.currUser.getId());
                        navigationMenuUserProductChange();
                    } else {
                        System.out.println("You does not own this product");
                    }
                    break;
                case 5:
                    ProductService.printProductsCurrentUser(UserService.currUser.getId());
                    MenuConsole.inputUser("your product id");
                     productId = scanner.nextInt();
                    if (ProductService.isProductBelongToUser(productId, UserService.currUser.getId())) {
                        ProductService.getCurrentProductUser(productId, UserService.currUser.getId());
                       double currentProductPrice =  ProductService.productCurrentUser.getProductPrice();
                       double currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();
                       double currentUserCash = UserService.currUser.getUserCash();
                        double priceChange = -(currentProductPrice * currentProductQuantity);
                        MenuConsole.changeProductPrice(priceChange, currentUserCash);
                        String confirmQuantityChange = scanner.next().toLowerCase();
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
                    ProductService.updateProductName(newProductName);
                    break;
                case 2:
                    MenuConsole.currentUserData("product type", ProductService.productCurrentUser.getProductType());
                    MenuConsole.inputUser("new product type");
                    String newProductType = scanner.next();
                    ProductService.updateProductType(newProductType);
                    break;
                case 3:
                    MenuConsole.currentUserData("product price", ProductService.productCurrentUser.getProductPrice());
                    MenuConsole.inputUser("new product price");
                     newProductPrice = scanner.nextDouble();

                     currentProductPrice =  ProductService.productCurrentUser.getProductPrice();
                     currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();

                    priceChange = ProductService.getPriceChange(newProductPrice, currentProductQuantity, currentProductPrice);

                    currentUserCash = UserService.currUser.getUserCash();

                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmPriceChange = scanner.next().toLowerCase();
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
                case 4:
                    MenuConsole.currentUserData("product quantity", ProductService.productCurrentUser.getProductQuantity());
                    MenuConsole.inputUser("new product quantity");
                    newProductQuantity = scanner.nextDouble();

                    currentProductPrice =  ProductService.productCurrentUser.getProductPrice();
                    currentProductQuantity = ProductService.productCurrentUser.getProductQuantity();

                    priceChange = ProductService.getPriceChange( newProductQuantity, currentProductPrice, currentProductQuantity);

                    currentUserCash = UserService.currUser.getUserCash();

                    MenuConsole.changeProductPrice(priceChange, currentUserCash);
                    String confirmQuantityChange = scanner.next().toLowerCase();
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
                case 5:
                    MenuConsole.currentUserData("product manufacturer", ProductService.productCurrentUser.getProductManufacturer());
                    MenuConsole.inputUser("new product manufacturer");
                    String newProductManuFacturer = scanner.next();
                    ProductService.updateProductManufacturer(newProductManuFacturer);
                    break;
                case 6:
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
        while (choice!=0) {
            MenuMain.menuUserShop();


            choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    MenuConsole.exiting();
                    navigationMenuUser();
                    break;
                case 1:
                    ProductService.printProductsAllUser();
                    break;
                case 2:
                    ProductService.printProductsAllUser();
                    MenuConsole.inputUser("seller id you want to buy from");
                    int sellerId = scanner.nextInt();
                    MenuConsole.inputUser("product id you want to buy");
                    int productId = scanner.nextInt();
                    if (ProductService.isProductBelongSeller(productId, sellerId)){
                        MenuConsole.inputUser("product quantity you want to buy");
                        int productQuantity = scanner.nextInt();
                        ProductService.getProductSeller(productId, sellerId);

                        //check if enough quantity
                        if (ProductService.isEnoughProductSeller(productQuantity)){
                            int orderId = PurchaseOrderService.getNewPOId();
                            int customerId = UserService.currUser.getId();
                            double productPrice = ProductService.productCurrentSeller.getProductPrice();
                            double totalCost = productPrice * productQuantity;

                            String productName = ProductService.productCurrentSeller.getProductName();

                            UserService.getCurrentSeller(sellerId);

                            String sellerName = UserService.currSeller.getUserName();
                            double currentUserCash = UserService.currUser.getUserCash();
                            MenuConsole.confirmPurchaseProduct(sellerId,sellerName,productId,productName,productPrice,productQuantity,currentUserCash);
                            String confirmPurchase = scanner.next().toLowerCase();
                            //check if user confirm to buy
                            if (confirmPurchase.equals("y")){
                                //check enough user cash
                                if (ProductService.isEnoughUserCash(totalCost)) {
                                    //create new po, add to poFile
                                    PurchaseOrder po = new PurchaseOrder(orderId,customerId,sellerId,productId,productPrice,productQuantity);
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
