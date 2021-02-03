package com.epam.task03.logic;

import com.epam.task03.data.DataException;
import com.epam.task03.data.DataReader;
import com.epam.task03.entities.Cube;
import com.epam.task03.parser.CubeParser;
import com.epam.task03.parser.CubeParserException;
import com.epam.task03.validator.DataValidator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class CubeCreatorTest {

    private static final List<String> TEST_DATA = Arrays.asList("1.0 2.0 3.0 4.0",
            "3g.0 4.0 6.0 1.0", "-1.0 2.0 3.0 4.0", "2.0 2.0 3.0 4.0", "1.0 2.0 3.0");
    private DataValidator validator = new DataValidator();
    private CubeParser parser = new CubeParser();

    @Test
    public void testProcessShouldSucceedWithProvidedTestData() throws DataException, CubeParserException {

        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.readData(anyString())).thenReturn(TEST_DATA);
        CubeCreator creator = new CubeCreator(reader, validator, parser);
        List<Cube> actual = creator.process(anyString());
        List<Cube> expected = new ArrayList<>();
        expected.add(new Cube(1.0, 2.0, 3.0, 4.0));
        expected.add(new Cube(2.0, 2.0, 3.0, 4.0));
        Assert.assertEquals(expected, actual);

    }
}
