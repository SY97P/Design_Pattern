package com.devcourse.observer.observer.subject;

import com.devcourse.observer.observer.object.Observer;

// 주체 : 객체 상태 변화 주시 관찰자
public interface Subject {
    void register(Observer oberser);
    void unregister(Observer observer);
    void notifyObservers();
    Object getUpdate(Observer observer);
}
