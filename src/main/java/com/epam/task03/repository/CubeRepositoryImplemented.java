package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.observable.IdGenerator;
import com.epam.task03.specifications.CubeSpecification;

import java.util.*;

public class CubeRepositoryImplemented implements CubeRepository {

    private Map<Integer, Cube> repository;
    private IdGenerator idGenerator;

    public CubeRepositoryImplemented() {
        this.repository = new HashMap<>();
        this.idGenerator = new IdGenerator();
    }

    @Override
    public void addCube(Cube cube) {
        repository.put(idGenerator.generateId(), cube);
    }

    public void addAllCubes(List<Cube> cubes) {
        for (Cube currentCube : cubes) {
            repository.put(idGenerator.generateId(), currentCube);
        }
    }

    @Override
    public void removeCube(Integer id) {
        repository.remove(id);
    }

    @Override
    public void updateCube(Integer id, Cube cube) {
        repository.replace(id, cube);
    }

    @Override
    public Map<Integer, Cube> query(CubeSpecification specification) {
        IdGenerator idGeneratorSpecifiedMap = new IdGenerator();
        Map<Integer, Cube> specifiedCubes = new HashMap<>();
        List<Cube> listOfCubes = new ArrayList<>(repository.values());
        for (Cube currentCube : listOfCubes) {
            if (specification.specified(currentCube)) {
                specifiedCubes.put(idGeneratorSpecifiedMap.generateId(), currentCube);
            }
        }
        return specifiedCubes;
    }

}
