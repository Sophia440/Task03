package com.epam.task03.entities;

public class Parameters {

    private double perimeter;
    private double area;
    private double volume;

    public Parameters(double perimeter, double area, double volume) {
        this.perimeter = perimeter;
        this.area = area;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Perimeter = " + perimeter + ", area = " + area + ", volume = " + volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        Parameters parameters = (Parameters) o;
        return Double.compare(parameters.perimeter, perimeter) == 0 &&
                Double.compare(parameters.area, area) == 0 &&
                Double.compare(parameters.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(perimeter) + Double.hashCode(area) + Double.hashCode(volume);
    }
}
