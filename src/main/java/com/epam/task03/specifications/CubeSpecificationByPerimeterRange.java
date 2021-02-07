package com.epam.task03.specifications;

import com.epam.task03.entities.Cube;
import com.epam.task03.logic.CubeCalculator;

public class CubeSpecificationByPerimeterRange implements CubeSpecification {

    private double minPerimeter;
    private double maxPerimeter;
    private CubeCalculator calculator;

    public CubeSpecificationByPerimeterRange(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
        this.calculator = new CubeCalculator();
    }

    @Override
    public boolean specified(Cube cube) {
        double perimeter = calculator.calculatePerimeter(cube);
        return perimeter >= minPerimeter && perimeter <= maxPerimeter;
    }

}
