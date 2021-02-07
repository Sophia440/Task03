package com.epam.task03.observer;

import com.epam.task03.entities.observable.CubeObservable;
import com.epam.task03.entities.Parameters;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CubeObserverTest {

    private final CubeObserver cubeObserver = CubeObserver.getInstance();
    private static final CubeObservable VALID_CUBE = new CubeObservable(2.0, 0.4, 0.0, -1.0);
    private static final double PERIMETER = 24.0;
    private static final double AREA = 24.0;
    private static final double VOLUME = 8.0;

    @Test
    public void testUpdateWithValidDataShouldSucceed() {
        VALID_CUBE.attachObserver(cubeObserver);
        Map<Integer, Parameters> expected = new HashMap<>();
        Parameters expectedMapParameters = new Parameters(PERIMETER, AREA, VOLUME);
        expected.put(0, expectedMapParameters);
        Map<Integer, Parameters> actual = cubeObserver.getParameters();
        Assert.assertEquals(expected, actual);
    }

}
