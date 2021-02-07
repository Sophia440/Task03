package com.epam.task03.observer;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.Parameters;
import com.epam.task03.entities.observable.IdGenerator;
import com.epam.task03.logic.CubeCalculator;

import java.util.HashMap;
import java.util.Map;

public class CubeObserver implements Observer {

    private static CubeObserver instance;
    private CubeCalculator calculator;
    private Map<Integer, Parameters> parameters;
    private IdGenerator idGenerator;

    private CubeObserver() {
        this.calculator = new CubeCalculator();
        this.parameters = new HashMap<>();
        this.idGenerator = new IdGenerator();
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
        double volume = calculator.calculateVolumeWholeCube(cube);
        Parameters cubeParameters = new Parameters(perimeter, area, volume);
        parameters.put(idGenerator.generateId(), cubeParameters);
    }
}
