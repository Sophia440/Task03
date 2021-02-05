package com.epam.task03.logic;

import com.epam.task03.entities.CubeObserved;
import com.epam.task03.entities.Parameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CubeObserverTest {

    private final CubeObserver cubeObserver = CubeObserver.getInstance();
    private static final double DELTA = 1e-15;
    private static final CubeObserved VALID_CUBE_OBSERVED =
            new CubeObserved(2.0, 0.4, 0.0, -1.0);
    private static final double PERIMETER = 24.0;
    private static final double AREA = 24.0;
    private static final double VOLUME = 8.0;

    @Test
    public void testUpdateShouldSucceedWithValidData() {
        VALID_CUBE_OBSERVED.attachObserver(cubeObserver);
        Map<Integer, Parameters> expected = new HashMap<>();
        Parameters expectedMapParameters = new Parameters(PERIMETER, AREA, VOLUME);
        expected.put(1, expectedMapParameters);
        Map<Integer, Parameters> actual = cubeObserver.getParameters();
        Assert.assertEquals(expected, actual);
    }

}
