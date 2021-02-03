package com.epam.task03;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.Point;
import com.epam.task03.logic.CubeLogic;

public class Main {
    public static void main(String[] args) {
        Cube cube = new Cube(1.0, 1.0, 1.0, 1.0);
        Point point = new Point(1.0, 1.0, 1.0);
        CubeLogic cubeLogic = new CubeLogic();
        System.out.println(cubeLogic.isACube(cube));
        System.out.println(cubeLogic.isACube(point));
    }
}
