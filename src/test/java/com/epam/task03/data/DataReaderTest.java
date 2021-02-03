package com.epam.task03.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataReaderTest {

    private static final String PATH_TO_INPUT_FILE = "./src/test/resources/input.txt";
    private static final List<String> VALID_DATA = Arrays.asList("1.0 0.0 3.0 0.0", "2.0 0.5 3.0 0.5");
    private static final List<String> INVALID_DATA = Arrays.asList("1.0 0.0 3.0 0.0", "2.0 0.5 3.0 0.5", "");
    private final DataReader reader = new DataReader();

    @Test
    public void testReadDataShouldSucceedWithProvidedPath() throws DataException {
        List<String> actualData = reader.readData(PATH_TO_INPUT_FILE);
        Assert.assertEquals(VALID_DATA, actualData);
    }

    @Test
    public void testReadDataShouldFailIfFileDoesNotEndWithSymbolOfNewLine() throws DataException {
        List<String> actualData = reader.readData(PATH_TO_INPUT_FILE);
        Assert.assertEquals(INVALID_DATA, actualData);
    }

}
