package com.epam.task03.specifications;

import com.epam.task03.entities.Cube;
import com.epam.task03.logic.CubeCalculator;

public class CubeSpecificationByVolumeRange implements CubeSpecification {

    private double minVolume;
    private double maxVolume;
    private CubeCalculator calculator;

    public CubeSpecificationByVolumeRange(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
        this.calculator = new CubeCalculator();
    }

    @Override
    public boolean specified(Cube cube) {
        double volume = calculator.calculateVolumeWholeCube(cube);
        return volume >= minVolume && volume <= maxVolume;
    }
    
}
