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

    public void setId(int id) {
        this.id = id;
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

    public boolean xCoordinateBetween(double minX, double maxX) {
        double xCoordinate = this.getCenterX();
        return xCoordinate >= minX && xCoordinate <= maxX;
    }

    public boolean yCoordinateBetween(double minY, double maxY) {
        double yCoordinate = this.getCenterY();
        return yCoordinate >= minY && yCoordinate <= maxY;
    }

    public boolean zCoordinateBetween(double minZ, double maxZ) {
        double zCoordinate = this.getCenterZ();
        return zCoordinate >= minZ && zCoordinate <= maxZ;
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
