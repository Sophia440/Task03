package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.specifications.CubeSpecification;

import java.util.ArrayList;
import java.util.List;

public class CubeRepositoryImplemented implements CubeRepository {

    private List<Cube> repository;

    public CubeRepositoryImplemented() {
        this.repository = new ArrayList<>();
    }

    public List<Cube> getRepository() {
        return repository;
    }

    @Override
    public void addCube(Cube cube) {
        repository.add(cube);
    }

    @Override
    public void removeCube(Cube cube) {
        repository.remove(cube);
    }

    public void removeAllCubes() {
        repository.clear();
    }

    @Override
    public void updateCube(Cube cube) throws NoSuchCubeException {
        int idToUpdate = cube.getId();
        int indexToUpdate = -1;
        for (Cube currentCube : repository) {
            if (currentCube.getId() == idToUpdate) {
                indexToUpdate = repository.indexOf(currentCube);
            }
        }
        if (indexToUpdate != -1) {
            removeCube(repository.get(indexToUpdate));
            addCube(cube);
        } else {
            throw new NoSuchCubeException("There is no cube with id = " + idToUpdate +
                    " in this repository");
        }
    }

    @Override
    public List<Cube> query(CubeSpecification specification) {
        List<Cube> specifiedCubes = new ArrayList<>();
        for (Cube currentCube : repository) {
            if (specification.specified(currentCube)) {
                specifiedCubes.add(currentCube);
            }
        }
        return specifiedCubes;
    }
}
