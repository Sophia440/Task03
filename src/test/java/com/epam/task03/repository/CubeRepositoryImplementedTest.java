package com.epam.task03.repository;

import com.epam.task03.entities.Cube;
import com.epam.task03.specifications.CubeSpecificationByAreaRange;
import com.epam.task03.specifications.CubeSpecificationByCenterCoordinates;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CubeRepositoryImplementedTest {

    private final CubeRepositoryImplemented repository = new CubeRepositoryImplemented();
    private static final Cube FIRST_CUBE = new Cube(1.0, 5.0, 5.0, 5.0);
    private static final Cube SECOND_CUBE = new Cube(2.0, 0.0, 0.0, 0.0);
    private static final Cube THIRD_CUBE = new Cube(3.0, -1.0, -1.0, -1.0);
    private static final List<Cube> CUBES = Arrays.asList(FIRST_CUBE, SECOND_CUBE, THIRD_CUBE);
    private static final List<Cube> EXPECTED = Arrays.asList(SECOND_CUBE);
    private static final double MIN_AREA = 10.0;
    private static final double MAX_AREA = 30.0;
    private static final double MIN_XYZ = 0.0;
    private static final double MAX_XYZ = 3.0;

    @Test()
    public void testQueryWithSpecificationByAreaRangeShouldSucceed() {
        repository.addAllCubes(CUBES);
        CubeSpecificationByAreaRange specification = new CubeSpecificationByAreaRange(MIN_AREA, MAX_AREA);
        Map<Integer, Cube> actualAsMap = repository.query(specification);
        List<Cube> actualAsList = new ArrayList<>(actualAsMap.values());
        Assert.assertEquals(EXPECTED, actualAsList);
    }

    @Test()
    public void testQueryWithSpecificationByCenterCoordinatesShouldSucceed() {
        repository.addAllCubes(CUBES);
        CubeSpecificationByCenterCoordinates specification = new CubeSpecificationByCenterCoordinates(MIN_XYZ, MAX_XYZ);
        Map<Integer, Cube> actualAsMap = repository.query(specification);
        List<Cube> actualAsList = new ArrayList<>(actualAsMap.values());
        Assert.assertEquals(EXPECTED, actualAsList);
    }

}
