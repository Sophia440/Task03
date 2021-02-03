package com.epam.task03.parser;

import com.epam.task03.entities.Cube;
import org.junit.Assert;
import org.junit.Test;

public class CubeParserTest {

    private final CubeParser parser = new CubeParser();
    private static final String POSITIVE_NUMBERS = "1.0 2.0 3.0 4.0";
    private static final String NEGATIVE_NUMBERS = "1.0 -2.0 -3.0 -4.0";
    private static final String CONTAINS_NON_NUMBERS = "1.0 -2.k0 -3.0 -4.0";

    @Test
    public void testParseShouldSucceedWithPositiveNumbers() throws CubeParserException {
        Cube expected = new Cube(1.0, 2.0, 3.0, 4.0);
        Cube actual = parser.parse(POSITIVE_NUMBERS);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testParseShouldSucceedWithNegativeNumbers() throws CubeParserException {
        Cube expected = new Cube(1.0, -2.0, -3.0, -4.0);
        Cube actual = parser.parse(NEGATIVE_NUMBERS);
        Assert.assertEquals(expected, actual);
    }

    @Test(expected = CubeParserException.class)
    public void testParseShouldSucceedAndThrowCubeParserExceptionWhenProvidedNonNumbers() throws CubeParserException {
        Cube expected = new Cube(1.0, -2.0, -3.0, -4.0);
        Cube actual = parser.parse(CONTAINS_NON_NUMBERS);
        Assert.assertEquals(expected, actual);
    }

}
