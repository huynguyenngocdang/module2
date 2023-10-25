package com.codegym.huy_c08.service;

import com.codegym.huy_c08.entity.User;

public interface UserServiceInterface {

    public void logIn(String username, String password);

    public boolean isUserExist(String username) ;

    public boolean isUserLoginCorrect(String username, String password) ;

    public User userLogin(String username, String password);


    public void userCreate(String username, String password) ;


    public void getCurrentUserInformation() ;
}
