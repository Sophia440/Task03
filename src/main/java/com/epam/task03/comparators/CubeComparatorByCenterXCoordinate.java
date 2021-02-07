package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterXCoordinate implements Comparator<Cube> {

    public int compare(Cube firstCube, Cube secondCube) {
        double firstCubeCenterX = firstCube.getCenterX();
        double secondCubeCenterX = secondCube.getCenterX();
        return Double.compare(firstCubeCenterX, secondCubeCenterX);
    }
}