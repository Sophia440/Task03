package com.epam.task03.entities;

import com.epam.task03.logic.CubeObserver;
import org.junit.Assert;
import org.junit.Test;


public class CubeObservedTest {
    private final CubeObserver cubeObserver = CubeObserver.getInstance();
    private static final double DELTA = 1e-15;
    private static final CubeObserved VALID_CUBE_OBSERVED =
            new CubeObserved(2.0, 0.4, 0.0, -1.0);
    private static final double NEGATIVE_EDGE_LENGTH = -2.0;

    @Test(expected = InvalidEdgeLengthException.class)
    public void testUpdateEdgeLengthSucceedWithNegativeNewEdge() throws InvalidEdgeLengthException {
        VALID_CUBE_OBSERVED.updateEdgeLength(NEGATIVE_EDGE_LENGTH);
        double actual = VALID_CUBE_OBSERVED.getEdgeLength();
        Assert.assertEquals(NEGATIVE_EDGE_LENGTH, actual, DELTA);
    }
}
