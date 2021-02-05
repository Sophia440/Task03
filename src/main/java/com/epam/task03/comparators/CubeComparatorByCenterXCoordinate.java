package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByCenterXCoordinate implements Comparator<Cube> {

    public int compare(Cube cubeA, Cube cubeB) {
        double cubeACenterX = cubeA.getCenterX();
        double cubeBCenterX = cubeB.getCenterX();
        return Double.compare(cubeACenterX, cubeBCenterX);
    }
}