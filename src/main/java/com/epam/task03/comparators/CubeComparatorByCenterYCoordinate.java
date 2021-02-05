package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterYCoordinate implements Comparator<Cube> {

    public int compare(Cube cubeA, Cube cubeB) {
        double cubeACenterY = cubeA.getCenterY();
        double cubeBCenterY = cubeB.getCenterY();
        return Double.compare(cubeACenterY, cubeBCenterY);
    }
}