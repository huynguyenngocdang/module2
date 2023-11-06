package com.codegym.huyc08.service;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    List<Observer> observers = new ArrayList<>();
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void notifyObserver() {
        for(var observer : observers) {
            observer.update();
        }
    }
}
