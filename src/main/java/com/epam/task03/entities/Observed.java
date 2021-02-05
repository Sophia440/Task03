package com.epam.task03.entities;

import com.epam.task03.logic.Observer;

public interface Observed {

    void attachObserver(Observer observer);

    void detachObserver(Observer observer);

    void notifyObservers();
}
