package com.epam.task03.entities.observed;

import com.epam.task03.observer.Observer;

public interface Observed {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();
}
