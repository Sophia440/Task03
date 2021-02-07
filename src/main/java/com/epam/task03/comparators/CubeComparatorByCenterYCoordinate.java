package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterYCoordinate implements Comparator<Cube> {

    public int compare(Cube firstCube, Cube secondCube) {
        double firstCubeCenterY = firstCube.getCenterY();
        double secondCubeCenterY = secondCube.getCenterY();
        return Double.compare(firstCubeCenterY, secondCubeCenterY);
    }
}