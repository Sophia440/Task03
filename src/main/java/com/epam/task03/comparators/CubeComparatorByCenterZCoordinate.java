package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterZCoordinate implements Comparator<Cube> {

    public int compare(Cube cubeA, Cube cubeB) {
        double cubeACenterZ = cubeA.getCenterZ();
        double cubeBCenterZ = cubeB.getCenterZ();
        return Double.compare(cubeACenterZ, cubeBCenterZ);
    }
}