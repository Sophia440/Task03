package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.specifications.CubeSpecificationByID;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeRepositoryImplementedTest {

    private final CubeRepositoryImplemented repository = new CubeRepositoryImplemented();
    private static final Cube VALID_CUBE = new Cube(2.0, 0.4, 0.0, -1.0);
    private static final Cube VALID_CUBE_TO_UPDATE_WITH = new Cube(3.0, 0.4, 0.0, -1.0);
    private static final Cube FIRST_CUBE_FOR_QUERY_TEST = new Cube(1.0, 0.0, 0.0, 0.0);
    private static final Cube SECOND_CUBE_FOR_QUERY_TEST = new Cube(2.0, 0.0, 0.0, 0.0);

    @Test(expected = NoSuchCubeException.class)
    public void testUpdateCubeShouldSucceedWithCubeThatDoesNotBelongToRepository()
            throws NoSuchCubeException {
        List<Cube> expected = Arrays.asList(VALID_CUBE);
        repository.updateCube(VALID_CUBE);
        Assert.assertEquals(expected, repository.getRepository());
    }

    @Test()
    public void testUpdateCubeShouldSucceedWithCubeThatDoesBelongToRepository()
            throws NoSuchCubeException {
        repository.addCube(VALID_CUBE);
        List<Cube> expected = Arrays.asList(VALID_CUBE_TO_UPDATE_WITH);
        int validCubeID = VALID_CUBE.getId();
        VALID_CUBE_TO_UPDATE_WITH.setId(validCubeID);
        repository.updateCube(VALID_CUBE_TO_UPDATE_WITH);
        Assert.assertEquals(expected, repository.getRepository());
    }

    @Test()
    public void testQueryShouldSucceedWithSpecificationByID() {
        repository.removeAllCubes();
        repository.addCube(FIRST_CUBE_FOR_QUERY_TEST);
        repository.addCube(SECOND_CUBE_FOR_QUERY_TEST);
        int secondCubeID = SECOND_CUBE_FOR_QUERY_TEST.getId();
        List<Cube> expected = Arrays.asList(SECOND_CUBE_FOR_QUERY_TEST);
        CubeSpecificationByID specificationByID = new CubeSpecificationByID(secondCubeID);
        List<Cube> actual = repository.query(specificationByID);
        Assert.assertEquals(expected, actual);
    }
}
