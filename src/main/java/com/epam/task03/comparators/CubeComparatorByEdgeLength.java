package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByEdgeLength implements Comparator<Cube> {

    public int compare(Cube firstCube, Cube secondCube) {
        double firstCubeEdgeLength = firstCube.getEdgeLength();
        double secondCubeEdgeLength = secondCube.getEdgeLength();
        return Double.compare(firstCubeEdgeLength, secondCubeEdgeLength);
    }
}