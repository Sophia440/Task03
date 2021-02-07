package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.specifications.CubeSpecification;

import java.util.Map;

public interface CubeRepository {

    void addCube(Cube cube);

    void removeCube(Integer id);

    void updateCube(Integer id, Cube cube);

    Map<Integer, Cube> query(CubeSpecification specification);

}
