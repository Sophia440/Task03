package com.epam.task03.comparators;

import com.epam.task03.entities.Cube;
import org.junit.Assert;
import org.junit.Test;

public class CubeComparatorsTest {

    private static final Cube FIRST_CUBE = new Cube(1.0, 1.0, 1.0, 1.0);
    private static final Cube SECOND_CUBE = new Cube(2.0, 2.0, 2.0, 2.0);

    @Test
    public void testCompareWithCenterXCoordinateShouldSucceed() {
        CubeComparatorByCenterXCoordinate comparator = new CubeComparatorByCenterXCoordinate();
        int actual = comparator.compare(SECOND_CUBE, FIRST_CUBE);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCompareWithCenterYCoordinateShouldSucceed() {
        CubeComparatorByCenterYCoordinate comparator = new CubeComparatorByCenterYCoordinate();
        int actual = comparator.compare(SECOND_CUBE, FIRST_CUBE);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCompareWithCenterZCoordinateShouldSucceed() {
        CubeComparatorByCenterZCoordinate comparator = new CubeComparatorByCenterZCoordinate();
        int actual = comparator.compare(SECOND_CUBE, FIRST_CUBE);
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCompareWithEdgeLengthShouldSucceed() {
        CubeComparatorByEdgeLength comparator = new CubeComparatorByEdgeLength();
        int actual = comparator.compare(SECOND_CUBE, FIRST_CUBE);
        Assert.assertEquals(1, actual);
    }

}
