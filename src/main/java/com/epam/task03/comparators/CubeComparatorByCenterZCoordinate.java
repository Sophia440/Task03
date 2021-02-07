package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterZCoordinate implements Comparator<Cube> {

    public int compare(Cube firstCube, Cube secondCube) {
        double firstCubeCenterZ = firstCube.getCenterZ();
        double secondCubeCenterZ = secondCube.getCenterZ();
        return Double.compare(firstCubeCenterZ, secondCubeCenterZ);
    }
}