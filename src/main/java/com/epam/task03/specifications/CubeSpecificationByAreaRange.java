package com.epam.task03.specifications;

import com.epam.task03.entities.Cube;
import com.epam.task03.logic.CubeCalculator;

public class CubeSpecificationByAreaRange implements CubeSpecification {

    private double minArea;
    private double maxArea;
    private CubeCalculator calculator;

    public CubeSpecificationByAreaRange(double minArea, double maxArea) {
        super();
        this.minArea = minArea;
        this.maxArea = maxArea;
        this.calculator = new CubeCalculator();
    }

    @Override
    public boolean specified(Cube cube) {
        double area = calculator.calculateArea(cube);
        return area >= minArea && area <= maxArea;
    }

}
