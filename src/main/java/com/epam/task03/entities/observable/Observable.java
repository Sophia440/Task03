package com.epam.task03.entities.observable;

import com.epam.task03.observer.Observer;

public interface Observable {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();
}
