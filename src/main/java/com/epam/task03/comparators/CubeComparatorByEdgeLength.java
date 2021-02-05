package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByEdgeLength implements Comparator<Cube> {

    public int compare(Cube cubeA, Cube cubeB) {
        double cubeAEdgeLength = cubeA.getEdgeLength();
        double cubeBEdgeLength = cubeB.getEdgeLength();
        return Double.compare(cubeAEdgeLength, cubeBEdgeLength);
    }
}