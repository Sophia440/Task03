package com.epam.task03.observer;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.Parameters;
import com.epam.task03.logic.CubeCalculator;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {

    private static CubeObserver instance;
    private CubeCalculator calculator;
    private Map<Integer, Parameters> parameters;

    private CubeObserver() {
        this.calculator = new CubeCalculator();
        this.parameters = new HashMap<>();
    }

    public static CubeObserver getInstance() {
        if (instance == null) {
            instance = new CubeObserver();
        }
        return instance;
    }

    public Map<Integer, Parameters> getParameters() {
        return parameters;
    }

    @Override
    public void update(Cube cube) {
        double perimeter = calculator.calculatePerimeter(cube);
        double area = calculator.calculateArea(cube);
        double volume = calculator.calculateVolumeOfWholeCube(cube);
        Parameters cubeParameters = new Parameters(perimeter, area, volume);
        parameters.put(cube.getId(), cubeParameters);
    }
}
