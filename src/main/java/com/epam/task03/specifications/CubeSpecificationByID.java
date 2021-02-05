package com.epam.task03.specifications;

import com.epam.task03.entities.Cube;

public class CubeSpecificationByID implements CubeSpecification {

    private int desiredID;

    public CubeSpecificationByID(int desiredID) {
        super();
        this.desiredID = desiredID;
    }

    @Override
    public boolean specified(Cube cube) {
        return cube.getId() == desiredID;
    }
}
