package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CubeComparatorsTest {

    private static final Cube FIRST_CUBE = new Cube(1.0, 1.0, 1.0, 1.0);
    private static final Cube SECOND_CUBE = new Cube(2.0, 2.0, 2.0, 2.0);
    private static final Cube THIRD_CUBE = new Cube(3.0, 3.0, 3.0, 3.0);
    private static final List<Cube> EXPECTED = Arrays.asList(FIRST_CUBE, SECOND_CUBE, THIRD_CUBE);

    @Test
    public void testCompareShouldSucceedWithComparatorByID() {
        List<Cube> actual = Arrays.asList(THIRD_CUBE, FIRST_CUBE, SECOND_CUBE);
        actual.sort(new CubeComparatorByID());
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testCompareShouldSucceedWithComparatorByCenterXCoordinate() {
        List<Cube> actual = Arrays.asList(THIRD_CUBE, FIRST_CUBE, SECOND_CUBE);
        actual.sort(new CubeComparatorByCenterXCoordinate());
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testCompareShouldSucceedWithComparatorByCenterYCoordinate() {
        List<Cube> actual = Arrays.asList(THIRD_CUBE, FIRST_CUBE, SECOND_CUBE);
        actual.sort(new CubeComparatorByCenterYCoordinate());
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testCompareShouldSucceedWithComparatorByCenterZCoordinate() {
        List<Cube> actual = Arrays.asList(THIRD_CUBE, FIRST_CUBE, SECOND_CUBE);
        actual.sort(new CubeComparatorByCenterZCoordinate());
        Assert.assertEquals(EXPECTED, actual);
    }

    @Test
    public void testCompareShouldSucceedWithComparatorByEdgeLength() {
        List<Cube> actual = Arrays.asList(THIRD_CUBE, FIRST_CUBE, SECOND_CUBE);
        actual.sort(new CubeComparatorByEdgeLength());
        Assert.assertEquals(EXPECTED, actual);
    }

}
