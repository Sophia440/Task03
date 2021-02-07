package com.epam.task03.entities.observable;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.Point;
import com.epam.task03.observer.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CubeObservable extends Cube implements Observable {

    private List<Observer> observers;

    public CubeObservable(double edgeLength, Point center) {
        super(edgeLength, center);
        this.observers = new ArrayList<>();
    }

    public CubeObservable(double edgeLength, double x, double y, double z) {
        super(edgeLength, x, y, z);
        this.observers = new ArrayList<>();
    }

    public void updateEdgeLength(double newEdgeLength) {
        this.setEdgeLength(newEdgeLength);
        notifyObservers();
    }

    @Override
    public void attachObserver(Observer observer) {
        this.observers.add(observer);
        observer.update(this);
    }

    @Override
    public void detachObserver(Observer observer) {
        this.observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        CubeObservable cubeObserved = (CubeObservable) o;
        return Objects.equals(observers, cubeObserved.observers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), observers);
    }

}
