package com.epam.task03.specifications;

import com.epam.task03.entities.Cube;

public class CubeSpecificationByCenterCoordinates implements CubeSpecification {

    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double minZ;
    private double maxZ;

    public CubeSpecificationByCenterCoordinates(double minX, double maxX, double minY, double maxY,
                                                double minZ, double maxZ) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.minZ = minZ;
        this.maxZ = maxZ;
    }

    public CubeSpecificationByCenterCoordinates(double minXYZ, double maxXYZ) {
        this.minX = minXYZ;
        this.maxX = maxXYZ;
        this.minY = minXYZ;
        this.maxY = maxXYZ;
        this.minZ = minXYZ;
        this.maxZ = maxXYZ;
    }

    @Override
    public boolean specified(Cube cube) {
        boolean xBelongsToDesiredRange = cube.xCoordinateBetween(minX, maxX);
        boolean yBelongsToDesiredRange = cube.yCoordinateBetween(minY, maxY);
        boolean zBelongsToDesiredRange = cube.zCoordinateBetween(minZ, maxZ);
        return xBelongsToDesiredRange && yBelongsToDesiredRange && zBelongsToDesiredRange;
    }
}
