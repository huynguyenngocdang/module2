package com.codegym.huy_c08.service;

import com.codegym.huy_c08.constants.Constants;
import com.codegym.huy_c08.entity.NormalUser;
import com.codegym.huy_c08.entity.Product;
import com.codegym.huy_c08.entity.Promotion;
import com.codegym.huy_c08.entity.PurchaseOrder;
import com.codegym.huy_c08.entity.User;
import com.codegym.huy_c08.menu.MenuConsole;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCartService {
    private ArrayList<Product> productsCart;
    private Map<Product, Double> productMap = new HashMap<>();
    private ArrayList<Product> products;
    private ArrayList<User> users;
    private ArrayList<Promotion> promotions;
    private ArrayList<PurchaseOrder> purchaseOrders;
    private final MyFileHandler fileHandler = new MyFileHandler();
    private final Type productType = new TypeToken<ArrayList<Product>>() {
    }.getType();
    private final Type userType = new TypeToken<ArrayList<NormalUser>>() {
    }.getType();
    private final Type promotionType = new TypeToken<ArrayList<Promotion>>() {
    }.getType();
    private User currentUser;
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_REGEX);
    private Date todayZeroTime;
    private final Type purchaseOrderType = new TypeToken<ArrayList<PurchaseOrder>>() {
    }.getType();
    private final PurchaseOrderService purchaseOrderService = new PurchaseOrderService();
    private final MenuConsole menuConsole = new MenuConsole();

    public ShoppingCartService() {
        try {
            this.todayZeroTime = dateFormat.parse(dateFormat.format(new Date()));
        } catch (ParseException parseException) {
            System.out.println(parseException.getMessage());
        }
        this.productsCart = new ArrayList<>();
        this.products = (ArrayList<Product>) fileHandler.readFromFile(Constants.PRODUCT_FILE_PATH, productType);
        this.users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
        this.promotions = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, promotionType);
        this.purchaseOrders = (ArrayList<PurchaseOrder>) fileHandler.readFromFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrderType);
    }

    public void refresh() {
        this.products = (ArrayList<Product>) fileHandler.readFromFile(Constants.PRODUCT_FILE_PATH, productType);
        this.users = (ArrayList<User>) fileHandler.readFromFile(Constants.USER_FILE_PATH, userType);
        this.promotions = (ArrayList<Promotion>) fileHandler.readFromFile(Constants.PROMOTION_FILE_PATH, promotionType);
        this.purchaseOrders = (ArrayList<PurchaseOrder>) fileHandler.readFromFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrderType);
    }

    public void addToCart(Product product, double quantity) {
        productMap.put(product, quantity);
    }

    public void showCart(User currentUser) {
        System.out.println("Product ID \t Product \t Quantity \t Price \t\t Total Price");
        double totalPrice = 0;
        double walletBalance = currentUser.getWalletBalance();
        for (Map.Entry<Product, Double> productIntegerEntry : productMap.entrySet()
        ) {
            int productId = productIntegerEntry.getKey().getProductId();
            String productName = productIntegerEntry.getKey().getProductName();
            double productQuantity = productIntegerEntry.getValue();
            double productPrice = productIntegerEntry.getKey().getProductPrice();
            double productTotalPrice = productPrice * productQuantity;
            totalPrice += productTotalPrice;
            System.out.println(productId + " \t\t\t " + productName + " \t " + productQuantity + " \t\t " + productPrice + " \t " + productTotalPrice);
        }
        System.out.println("Total price to pay: " + totalPrice);
        System.out.println("Your wallet balance: " + walletBalance);
        System.out.println("Your wallet balance after purchase: " + (walletBalance - totalPrice));
    }

    public Product getProduct(int productId, int sellerId) {
        for (Product product : products
        ) {
            if (product.getSellerId() == sellerId && product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void removeAllProductInCart() {
        productMap.clear();
    }

    public void checkOut(User currentUserInput) {
        this.currentUser = getCurrentUser(currentUserInput.getUserId());
        if (isUserHasEnoughCash()) {
            int userId = currentUser.getUserId();
            double totalPrice = 0;
            double walletBalance = currentUser.getWalletBalance();
            for (Map.Entry<Product, Double> productIntegerEntry : productMap.entrySet()
            ) {
                Product productInMap = productIntegerEntry.getKey();
                double productQuantity = productIntegerEntry.getValue();
                int purchaseOrderId = getNewPurchaseOrderId();
                int sellerId = productInMap.getSellerId();
                int productId = productInMap.getProductId();
                double productPrice = productInMap.getProductPrice();
                double productTotalPrice = productPrice * productQuantity;
                totalPrice += productTotalPrice;

                //create new Purchase Order;
                PurchaseOrder newPurchaseOrder = new PurchaseOrder(purchaseOrderId, userId, sellerId, productId, productPrice, productQuantity, productTotalPrice);
                addPurchaseOrders(newPurchaseOrder);
                updatePurchaseOrders();
                //update product in shop
                Product productInShop = findProductInShop(productInMap);
                double productCurrentQuantity = productInShop.getProductQuantity();
                productInShop.setProductQuantity(productCurrentQuantity - productQuantity);
                updateProducts();
                //update seller
                User seller = getCurrentUser(productInMap.getSellerId());
                double sellerCurrentBalance = seller.getWalletBalance();
                seller.setWalletBalance(sellerCurrentBalance + productTotalPrice);
                updateUsers();
            }
            //update buyer
            this.currentUser.setWalletBalance(walletBalance - totalPrice);
            updateUsers();

            //remove all cart item;
            removeAllProductInCart();
        } else {
            menuConsole.notEnoughCash("make this purchse");
        }
    }

    public void checkOut(User currentUserInput, String promotionCode) {
        this.currentUser = getCurrentUser(currentUserInput.getUserId());
        int userId = currentUser.getUserId();
        Promotion promotion = getPromotion(promotionCode);
        String promotionName = promotion.getPromotionCode();
        double promotionAmount = promotion.getPromotionAmount();
        double promotionPercent = promotion.getPromotionPercent() * Constants.PERCENT;
        if (isPromotionValidate(promotion)) {
            if (isUserHasEnoughCash(promotion)) {
                double totalPrice = 0;
                double walletBalance = currentUser.getWalletBalance();
                for (Map.Entry<Product, Double> productIntegerEntry : productMap.entrySet()
                ) {
                    Product productInMap = productIntegerEntry.getKey();
                    double productQuantity = productIntegerEntry.getValue();
                    double productPrice = productIntegerEntry.getKey().getProductPrice();
                    int purchaseOrderId = getNewPurchaseOrderId();
                    int sellerId = productInMap.getSellerId();
                    int productId = productInMap.getProductId();
                    double productTotalPriceOrigin = productPrice * productQuantity;
                    double productTotalPrice = productPrice * productQuantity * (1 - promotionPercent) - promotionAmount;
                    totalPrice += productTotalPrice;

                    //create new PO
                    PurchaseOrder newPurchaseOrder = new PurchaseOrder(purchaseOrderId, userId, sellerId,productId, productPrice, productQuantity, productTotalPriceOrigin, productTotalPrice, promotionName,promotionAmount,promotionPercent);
                    addPurchaseOrders(newPurchaseOrder);
                    updatePurchaseOrders();
                    //update product in shop
                    Product productInShop = findProductInShop(productInMap);
                    double productCurrentQuantity = productInShop.getProductQuantity();
                    productInShop.setProductQuantity(productCurrentQuantity - productQuantity);
                    updateProducts();
                    //update seller
                    User seller = getCurrentUser(productInMap.getSellerId());
                    double sellerCurrentBalance = seller.getWalletBalance();
                    seller.setWalletBalance(sellerCurrentBalance + productTotalPrice);
                    updateUsers();
                }
                //update buyer
                this.currentUser.setWalletBalance(walletBalance - totalPrice);
                updateUsers();
                //remove all cart item;
                removeAllProductInCart();
            } else {
                menuConsole.notEnoughCash("make this purchase");
            }
        } else {
            menuConsole.promotionAlreadyEnd();
        }
    }


    private void updateUsers() {
        fileHandler.saveToFile(Constants.USER_FILE_PATH, users);
    }

    private void updateProducts() {
        fileHandler.saveToFile(Constants.PRODUCT_FILE_PATH, products);
    }
    private void updatePurchaseOrders(){
        fileHandler.saveToFile(Constants.PURCHASE_ORDER_FILE_PATH, purchaseOrders);
    }
    private void addPurchaseOrders(PurchaseOrder purchaseOrder) {
        purchaseOrders.add(purchaseOrder);
    }

    public Product findProductInShop(Product productFind) {
        for (Product product : products
        ) {
            if (productFind.getProductId() == product.getProductId()) {
                return product;
            }
        }
        return null;
    }

    public User getCurrentUser(int userId) {
        for (User user : users
        ) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    public boolean isUserHasEnoughCash() {
        double totalPrice = 0;
        double walletBalance = currentUser.getWalletBalance();
        for (Map.Entry<Product, Double> productIntegerEntry : productMap.entrySet()
        ) {
            double productQuantity = productIntegerEntry.getValue();
            double productPrice = productIntegerEntry.getKey().getProductPrice();
            double productTotalPrice = productPrice * productQuantity;
            totalPrice += productTotalPrice;
        }
        return (walletBalance - totalPrice >= 0);
    }

    public boolean isUserHasEnoughCash(Promotion promotion) {
        double totalPrice = 0;
        double walletBalance = currentUser.getWalletBalance();
        double promotionAmount = promotion.getPromotionAmount();
        double promotionPercent = promotion.getPromotionPercent() * Constants.PERCENT;
        for (Map.Entry<Product, Double> productIntegerEntry : productMap.entrySet()
        ) {
            double productQuantity = productIntegerEntry.getValue();
            double productPrice = productIntegerEntry.getKey().getProductPrice();
            double productTotalPrice = productPrice * productQuantity * (1 - promotionPercent) - promotionAmount;
            totalPrice += productTotalPrice;
        }
        return (walletBalance - totalPrice >= 0);
    }

    public boolean isPromotionExist(String promotionName) {
        for (Promotion promotion : promotions
        ) {
            if (promotion.getPromotionCode().equals(promotionName)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPromotionValidate(Promotion promotion) {
        try {
            Date endate = dateFormat.parse(promotion.getPromotionDateEnd());
            return (endate.compareTo(todayZeroTime) >= 0);
        } catch (ParseException parseException) {
            return false;
        }
    }

    public Promotion getPromotion(String promotionName) {
        for (Promotion promotion : promotions
        ) {
            if (promotion.getPromotionCode().equals(promotionName)) {
                return promotion;
            }
        }
        return null;
    }

    public int getNewPurchaseOrderId() {
        int max = 0;
        for (PurchaseOrder po : purchaseOrders
        ) {
            if (max < po.getPurchaseOrderId()) {
                max = po.getPurchaseOrderId();
            }
        }
        return max + 1;
    }

}
