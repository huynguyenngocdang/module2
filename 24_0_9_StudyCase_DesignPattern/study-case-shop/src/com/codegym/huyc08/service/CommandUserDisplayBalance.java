package com.codegym.huyc08.service;

public class CommandUserDisplayBalance implements Command {
    @Override
    public void execute() {
        System.out.println("Your user balance is");
        System.out.println(SingletonCurrentUser.getInstance().getCurrentUser().getWalletBalance());
    }
}
