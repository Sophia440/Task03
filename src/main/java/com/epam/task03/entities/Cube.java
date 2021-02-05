package com.epam.task03.entities;

public class Cube {
    private static int count = 1;
    private int id;
    private Point center;
    private double edgeLength;

    public Cube(double edgeLength, Point center) {
        this.center = center;
        this.edgeLength = edgeLength;
        this.id = count;
        count++;
    }

    public Cube(double edgeLength, double x, double y, double z) {
        this(edgeLength, new Point(x, y, z));
    }

    public int getId() {
        return id;
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

    public double getEdgeLength() {
        return edgeLength;
    }

    protected void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }

    @Override
    public String toString() {
        return "Id: " + id + ", center coordinates: " + center + ", edgeLength = " + edgeLength;
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
        return cube.id == id &&
                Double.compare(cube.edgeLength, edgeLength) == 0 &&
                center.equals(cube.center);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id) + Double.hashCode(edgeLength) + center.hashCode();
    }
}
