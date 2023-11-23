package com.codegym.huyc08.service;

import com.codegym.huyc08.entity.Product;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommandRemoveUserProduct extends Subject implements Command{
    private Scanner SCANNER;
    @Override
    public void execute() {
     try {
         SCANNER = new Scanner(System.in);
         Command command = new CommandUserDisplayProducts();
         command.execute();
         System.out.println("Input your product lines you want to remove");
         int choice = SCANNER.nextInt() - 1;
         Product product = SingletonCurrentUserListProducts.getInstance().getCurrentUsersProduct().get(choice);
         Confirm confirm = new Confirmation("remove this product " + product.toString());
         if(confirm.isConfirm()) {

             Observer observerListProducts = SingletonListProduct.getInstance();
             Observer observerListCurrentUserProducts = SingletonCurrentUserListProducts.getInstance();

             addObserver(observerListProducts);
             addObserver(observerListCurrentUserProducts);
             SingletonCurrentUserListProducts.getInstance().removeUserProduct(choice);
             notifyObserver();
             removeObserver(observerListCurrentUserProducts);
             removeObserver(observerListProducts);
         } else {
             System.out.println("You have not remove this product " + product.toString());
         }
     } catch (IndexOutOfBoundsException | InputMismatchException exception) {
         System.out.println("Invalid choice, please try again");
     }

    }
}
