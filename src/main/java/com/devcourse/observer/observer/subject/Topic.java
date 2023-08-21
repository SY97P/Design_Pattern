package com.devcourse.observer.observer.subject;

import com.devcourse.observer.observer.object.Observer;

import java.util.ArrayList;
import java.util.List;

public class Topic implements Subject {
    private List<Observer> observers;
    private String message;

    public Topic() {
        this.observers = new ArrayList<>();
        this.message = "";
    }

    @Override
    public void register(Observer oberser) {
        if (!observers.contains(oberser)) {
            observers.add(oberser);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::update);
    }

    @Override
    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String msg) {
        System.out.println("Message sended to Topic : " + msg);
        this.message = msg;
        notifyObservers();
    }
}
