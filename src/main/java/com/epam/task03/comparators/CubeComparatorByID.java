package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;

import java.util.Comparator;

public class CubeComparatorByID implements Comparator<Cube> {

    public int compare(Cube cubeA, Cube cubeB) {
        int cubeAID = cubeA.getId();
        int cubeBID = cubeB.getId();
        return Integer.compare(cubeAID, cubeBID);
    }
}