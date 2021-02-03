package com.epam.task03.logic;

import com.epam.task03.entities.Cube;
import com.epam.task03.entities.Point;
import org.junit.Assert;
import org.junit.Test;

public class CubeLogicTest {

    private final CubeLogic cubeLogic = new CubeLogic();
    private static final Cube VALID_CUBE = new Cube(2.0, 0.4, 0.0, -1.0);
    private static final Cube CUBE_WITH_CENTER_IN_ZERO = new Cube(2.0, 0.0, 0.0, 0.0);
    private static final Cube UNCUT_CUBE = new Cube(2.0, 3.0, 3.0, 3.0);
    private static final Point VALID_POINT = new Point(1.0, 1.0, 1.0);
    private static final double DELTA = 1e-15;

    @Test
    public void testCalculateAreaShouldSucceed() {
        double expected = 24.0;
        double actual = cubeLogic.calculateArea(VALID_CUBE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeShouldSucceed() {
        double expected = 8.0;
        double actual = cubeLogic.calculateVolumeOfWholeCube(VALID_CUBE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeRatioWhenCubeIsCutByACoordinateHyperplaneShouldSucceedWithCenterNotInZero() {
        double expected = 0.25;
        double actual = cubeLogic.calculateVolumeRatioWhenCubeIsCutByACoordinateHyperplane(VALID_CUBE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeRatioWhenCubeIsCutByACoordinateHyperplaneShouldSucceedWithCenterInZero() {
        double expected = 0.5;
        double actual = cubeLogic.calculateVolumeRatioWhenCubeIsCutByACoordinateHyperplane(
                CUBE_WITH_CENTER_IN_ZERO);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testCalculateVolumeRatioWhenCubeIsCutByACoordinateHyperplaneShouldSucceedWithUncutCube() {
        double expected = 1.0;
        double actual = cubeLogic.calculateVolumeRatioWhenCubeIsCutByACoordinateHyperplane(UNCUT_CUBE);
        Assert.assertEquals(expected, actual, DELTA);
    }

    @Test
    public void testHasASideThatBelongsToACoordinateHyperplaneShouldSucceedWhenCubeHasSideLikeThat() {
        Assert.assertTrue(cubeLogic.hasASideThatBelongsToACoordinateHyperplane(VALID_CUBE));
    }

    @Test
    public void testHasASideThatBelongsToACoordinateHyperplaneShouldSucceedWhenCubeHasNoSideLikeThat() {
        Assert.assertFalse(cubeLogic.hasASideThatBelongsToACoordinateHyperplane(CUBE_WITH_CENTER_IN_ZERO));
    }

    @Test
    public void testIsACubeShouldSucceedWithObjectOfCubeClass() {
        Assert.assertTrue(cubeLogic.isACube(VALID_CUBE));
    }

    @Test
    public void testIsACubeShouldFailWithObjectOfOtherClass() {
        Assert.assertTrue(cubeLogic.isACube(VALID_POINT));
    }
}
