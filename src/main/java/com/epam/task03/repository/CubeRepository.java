package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.specifications.CubeSpecification;

import java.util.List;

public interface CubeRepository {

    void addCube(Cube cube);

    void removeCube(Cube cube);

    void updateCube(Cube cube) throws NoSuchCubeException;

    List<Cube> query(CubeSpecification specification);

}
