package com.manieri.projetoaraucaria.util;

import java.util.ArrayList;
import java.util.List;

public class LiveData {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public void putData(Object obj) {
        notifyObserver();
    }
}
