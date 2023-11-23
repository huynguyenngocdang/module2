package com.codegym.huyc08.backup;

import com.codegym.huyc08.constant.AppConstant;
import com.codegym.huyc08.entity.CartItem;
import com.codegym.huyc08.entity.NormalUser;
import com.codegym.huyc08.entity.Product;
import com.codegym.huyc08.entity.Promotion;
import com.codegym.huyc08.entity.PurchaseOrder;
import com.codegym.huyc08.entity.PurchaseOrderFactory;
import com.codegym.huyc08.service.Command;
import com.codegym.huyc08.service.CommandGetAllProductInformationInCart;
import com.codegym.huyc08.service.Confirm;
import com.codegym.huyc08.service.Confirmation;
import com.codegym.huyc08.service.GenerateId;
import com.codegym.huyc08.service.Observer;
import com.codegym.huyc08.service.SingletonCurrentPromotion;
import com.codegym.huyc08.service.SingletonCurrentUser;
import com.codegym.huyc08.service.SingletonCurrentUserDelivery;
import com.codegym.huyc08.service.SingletonListNormalUser;
import com.codegym.huyc08.service.SingletonListProduct;
import com.codegym.huyc08.service.SingletonListPurchaseOrder;
import com.codegym.huyc08.service.SingletonShoppingCart;
import com.codegym.huyc08.service.Subject;
import com.codegym.huyc08.service.Validator;
import com.codegym.huyc08.service.ValidatorDateBeforeDate;
import com.codegym.huyc08.service.ValidatorPromotionExistByCode;
import com.codegym.huyc08.service.ValidatorUserHasEnoughCash;
import com.codegym.huyc08.service.ValidatorUserHasEnoughCashWithPromotion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CommandCheckout extends Subject implements Command {
    private List<CartItem> cartItems;
    private List<NormalUser> users;
    private List<Product> products;
    private List<PurchaseOrder> purchaseOrders;
    private final Scanner SCANNER;

    public CommandCheckout() {
        this.cartItems = SingletonShoppingCart.getInstance().getCartItems();
        this.users = SingletonListNormalUser.getInstance().getUsers();
        this.products = SingletonListProduct.getInstance().getProducts();
        this.purchaseOrders = SingletonListPurchaseOrder.getInstance().getPurchaseOrders();
        this.SCANNER = new Scanner(System.in);

    }

    @Override
    public void execute() {
        if (cartItems.isEmpty()) {
            System.out.println("You don't have any item to check out");
        } else {
            //display current cart + confirm - check enough balance - checkout
            Command displayCurrentCart = new CommandGetAllProductInformationInCart();
            displayCurrentCart.execute();
            Confirm confirm = new Confirmation("check out");
            if (confirm.isConfirm()) {
                Confirm applyPromotion = new Confirmation("apply promotion");
                if (applyPromotion.isConfirm()) {
                    System.out.println("Input your promotion code");
                    String promotionCode = SCANNER.nextLine();
                    Validator validatePromotion = new ValidatorPromotionExistByCode(promotionCode);
                    if (validatePromotion.isCheck()) {
                        checkOutWithPromotion(promotionCode);
                    } else {
                        System.out.println("There is no promotion code");
                    }
                } else {
                    System.out.println("You have not apply a promotion code");
                    System.out.println("Proceeding to check out");
                    checkOutWithoutPromotion();
                }
            }
        }
    }

    private void checkOutWithPromotion(String promotionCode) {
        //set current promotion
        SingletonCurrentPromotion.getInstance().setCurrentPromotion(promotionCode);
        Promotion thisPromotion = SingletonCurrentPromotion.getInstance().getCurrentPromotion();
        SimpleDateFormat format = new SimpleDateFormat(AppConstant.DATE_PATTERN_REGEX);
        String today = format.format(new Date());
        Validator validateEndDate = new ValidatorDateBeforeDate(today, thisPromotion.getPromotionDateEnd());
        if (validateEndDate.isCheck()) {
            Validator validateEnoughCashWithPromotion = new ValidatorUserHasEnoughCashWithPromotion();
            if (validateEnoughCashWithPromotion.isCheck()) {
                Iterator<CartItem> cartItemIterator = cartItems.iterator();

                double promotionPercent = thisPromotion.getPromotionPercent() * AppConstant.PERCENT;
                double promotionAmount = thisPromotion.getPromotionAmount();

                Observer productObserver = SingletonListProduct.getInstance();
                Observer normalUserObserver = SingletonListNormalUser.getInstance();
                Observer mailingObserver = SingletonCurrentUserDelivery.getInstance();
                Observer purchaseOrderObserver = SingletonListPurchaseOrder.getInstance();

                PurchaseOrderFactory factory = new PurchaseOrderFactory();
                addObserver(productObserver);
                addObserver(normalUserObserver);
                addObserver(mailingObserver);
                addObserver(purchaseOrderObserver);

                while (cartItemIterator.hasNext()) {
                    CartItem currentCartLine = cartItemIterator.next();
                    GenerateId generateId = SingletonListPurchaseOrder.getInstance();
                    int newPOId = generateId.getNewId();
                    int userId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
                    int sellerId = currentCartLine.getProduct().getSellerId();
                    int productId = currentCartLine.getProduct().getProductId();
                    double productPrice = currentCartLine.getProduct().getProductPrice();
                    double productQuantity = currentCartLine.getQuantity();
                    double productTotalPriceOrigin = currentCartLine.getQuantity() * currentCartLine.getProduct().getProductPrice();
                    double productTotalPrice = productPrice * productQuantity * (1 - promotionPercent) - promotionAmount;

                    //update product:
                    Product thisProduct = SingletonListProduct.getInstance().getProduct(currentCartLine.getProduct().getProductId());
                    thisProduct.setProductQuantity(thisProduct.getProductQuantity() - currentCartLine.getQuantity());

                    //update seller:
                    NormalUser seller = SingletonListNormalUser.getInstance().getCurrentUser(currentCartLine.getProduct().getSellerId());
                    seller.setWalletBalance(seller.getWalletBalance() + productTotalPrice);

                    //update buyer:
                    NormalUser buyer = SingletonCurrentUser.getInstance().getCurrentUser();
                    buyer.setWalletBalance(buyer.getWalletBalance() - productTotalPrice);

                    //create purchase order
                    //purchaseOrderId, userId, sellerId,productId, productPrice, productQuantity, productTotalPriceOrigin, productTotalPrice, promotionName,promotionAmount,promotionPercent
                    PurchaseOrder newPO = factory.createNewPO(newPOId, userId, sellerId, productId, productPrice, productQuantity, productTotalPriceOrigin, productTotalPrice, promotionCode, promotionAmount, promotionPercent);
                    purchaseOrders.add(newPO);
                    //remove cartItemLine:
                    cartItemIterator.remove();
                }
                notifyObserver();
                removeObserver(productObserver);
                removeObserver(normalUserObserver);
                removeObserver(mailingObserver);
                removeObserver(purchaseOrderObserver);
            } else {
                System.out.println("You don't have enough cash to make this purchase");
            }
        } else {
            System.out.println("This promotion code has expired");
        }
    }

    private void checkOutWithoutPromotion() {
        Validator validateUserEnoughCash = new ValidatorUserHasEnoughCash();
        if (validateUserEnoughCash.isCheck()) {
            Iterator<CartItem> cartItemIterator = cartItems.iterator();
            Observer productObserver = SingletonListProduct.getInstance();
            Observer normalUserObserver = SingletonListNormalUser.getInstance();
            Observer mailingObserver = SingletonCurrentUserDelivery.getInstance();
            Observer purchaseOrderObserver = SingletonListPurchaseOrder.getInstance();

            PurchaseOrderFactory factory = new PurchaseOrderFactory();
            addObserver(productObserver);
            addObserver(normalUserObserver);
            addObserver(mailingObserver);
            addObserver(purchaseOrderObserver);

            while (cartItemIterator.hasNext()) {
                CartItem currentCartLine = cartItemIterator.next();
                double cost = currentCartLine.getQuantity() * currentCartLine.getProduct().getProductPrice();


                //update product:
                Product thisProduct = SingletonListProduct.getInstance().getProduct(currentCartLine.getProduct().getProductId());
                thisProduct.setProductQuantity(thisProduct.getProductQuantity() - currentCartLine.getQuantity());

                //update seller:
                NormalUser seller = SingletonListNormalUser.getInstance().getCurrentUser(currentCartLine.getProduct().getSellerId());
                seller.setWalletBalance(seller.getWalletBalance() + cost);

                //update buyer:
                NormalUser buyer = SingletonCurrentUser.getInstance().getCurrentUser();
                buyer.setWalletBalance(buyer.getWalletBalance() - cost);

                //create purchase order
                //purchaseOrderId, userId, sellerId, productId, productPrice, productQuantity, productTotalPrice
                GenerateId generateId = SingletonListPurchaseOrder.getInstance();
                int newPOId = generateId.getNewId();
                int userId = SingletonCurrentUser.getInstance().getCurrentUser().getUserId();
                int sellerId = currentCartLine.getProduct().getSellerId();
                int productId = currentCartLine.getProduct().getProductId();
                double productPrice = currentCartLine.getProduct().getProductPrice();
                double productQuantity = currentCartLine.getQuantity();
                double totalPrice = cost;
                PurchaseOrder newPO = factory.createNewPO(newPOId, userId, sellerId, productId, productPrice, productQuantity, totalPrice);
                purchaseOrders.add(newPO);
                //remove cartItemLine:
                cartItemIterator.remove();
            }
            notifyObserver();
            removeObserver(productObserver);
            removeObserver(normalUserObserver);
            removeObserver(mailingObserver);
            removeObserver(purchaseOrderObserver);
        } else {
            System.out.println("You don't have enough cash to make this purchase");
        }
    }
}
