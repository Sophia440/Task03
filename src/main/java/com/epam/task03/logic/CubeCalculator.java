package com.epam.task03.logic;

import com.epam.task03.entities.Cube;

public class CubeCalculator {

    private static final double NUMBER_OF_CUBE_SIDES = 6.0;
    private static final double NUMBER_OF_CUBE_EDGES = 12.0;
    private static final double RATIO_OF_AN_UNCUT_CUBE = 1.0;
    private static final double RATIO_OF_A_CUBE_WITH_CENTER_IN_ZERO = 0.5;
    private static final int SECOND_POWER = 2;
    private static final int THIRD_POWER = 3;
    private static final String NAME_OF_THE_CUBE_CLASS = "com.epam.task03.entities.Cube";

    public double calculatePerimeter(Cube cube) {
        return cube.getEdgeLength() * NUMBER_OF_CUBE_EDGES;
    }

    public double calculateArea(Cube cube) {
        double sideArea = Math.pow(cube.getEdgeLength(), SECOND_POWER);
        return sideArea * NUMBER_OF_CUBE_SIDES;
    }

    public double calculateVolumeOfWholeCube(Cube cube) {
        return Math.pow(cube.getEdgeLength(), THIRD_POWER);
    }

    public boolean isACube(Object object) {
        Class givenObjectClass = object.getClass();
        String nameOfTheGivenObjectClass = givenObjectClass.getName();
        return nameOfTheGivenObjectClass.equals(NAME_OF_THE_CUBE_CLASS);
    }

    public double calculateVolumeRatioWhenCubeIsCutByACoordinateHyperplane(Cube cube) {
        double edgeLength = cube.getEdgeLength();
        double xCoordinate = cube.getCenterX();
        double yCoordinate = cube.getCenterY();
        double zCoordinate = cube.getCenterZ();
        boolean checkXHyperplane = doesASideCrossACoordinateHyperplane(xCoordinate, edgeLength);
        if (checkXHyperplane) {
            return calculateVolumeRatioWithGivenCoordinateHyperplane(xCoordinate, edgeLength);
        }
        boolean checkYHyperplane = doesASideCrossACoordinateHyperplane(yCoordinate, edgeLength);
        if (checkYHyperplane) {
            return calculateVolumeRatioWithGivenCoordinateHyperplane(yCoordinate, edgeLength);
        }
        boolean checkZHyperplane = doesASideCrossACoordinateHyperplane(zCoordinate, edgeLength);
        if (checkZHyperplane) {
            return calculateVolumeRatioWithGivenCoordinateHyperplane(zCoordinate, edgeLength);
        }
        return RATIO_OF_AN_UNCUT_CUBE;
    }

    private double calculateVolumeRatioWithGivenCoordinateHyperplane(double coordinate, double edgeLength) {
        if (coordinate == 0.0) {
            return RATIO_OF_A_CUBE_WITH_CENTER_IN_ZERO;
        }
        double heightOfFirstPart = Math.abs(coordinate);
        double heightOfSecondPart = edgeLength - heightOfFirstPart;
        return heightOfFirstPart / heightOfSecondPart;
    }

    private boolean doesASideCrossACoordinateHyperplane(double coordinate, double edgeLength) {
        double absoluteCoordinate = Math.abs(coordinate);
        double distanceBetweenSideAndCenter = edgeLength / 2;
        return absoluteCoordinate < distanceBetweenSideAndCenter;
    }

    private boolean doesASideBelongToACoordinateHyperplane(double coordinate, double edgeLength) {
        double absoluteCoordinate = Math.abs(coordinate);
        double distanceBetweenSideAndCenter = edgeLength / 2;
        return absoluteCoordinate == distanceBetweenSideAndCenter;
    }

    public boolean hasASideThatBelongsToACoordinateHyperplane(Cube cube) {
        double edgeLength = cube.getEdgeLength();
        boolean checkXHyperplane = doesASideBelongToACoordinateHyperplane(cube.getCenterX(), edgeLength);
        boolean checkYHyperplane = doesASideBelongToACoordinateHyperplane(cube.getCenterY(), edgeLength);
        boolean checkZHyperplane = doesASideBelongToACoordinateHyperplane(cube.getCenterZ(), edgeLength);
        if (checkXHyperplane || checkYHyperplane || checkZHyperplane) {
            return true;
        }
        return false;
    }

}
