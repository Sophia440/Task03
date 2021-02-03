package com.epam.task03.entities;

public class Cube {
    private Point center;
    private double edgeLength;

    public Cube(double edgeLength, Point center) {
        this.center = center;
        this.edgeLength = edgeLength;
    }

    public Cube(double edgeLength, double x, double y, double z) {
        this(edgeLength, new Point(x, y, z));
    }

    public double getEdgeLength() {
        return edgeLength;
    }

    public double getCenterX() {
        return center.getX();
    }

    public double getCenterY() {
        return center.getY();
    }

    public double getCenterZ() {
        return center.getZ();
    }

    @Override
    public String toString() {
        return "Center coordinates: " + center +
                ", edgeLength = " + edgeLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }
        Cube cube = (Cube) o;
        return Double.compare(cube.edgeLength, edgeLength) == 0 &&
                center.equals(cube.center);
    }

    @Override
    public int hashCode() {
        return Double.hashCode(edgeLength) + center.hashCode();
    }
}
