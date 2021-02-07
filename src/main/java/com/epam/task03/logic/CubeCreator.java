package com.epam.task03.logic;

import com.epam.task03.data.DataException;
import com.epam.task03.data.DataReader;
import com.epam.task03.entities.Cube;
import com.epam.task03.parser.CubeParser;
import com.epam.task03.validator.DataValidator;

import java.util.ArrayList;
import java.util.List;

public class CubeCreator {

    private DataReader reader;
    private DataValidator validator;
    private CubeParser parser;

    public CubeCreator(DataReader reader, DataValidator validator, CubeParser parser) {
        this.reader = reader;
        this.validator = validator;
        this.parser = parser;
    }

    public List<Cube> process(String filename) throws DataException {
        List<String> lines = reader.readData(filename);
        List<String> validLines = new ArrayList<>();
        for (String line : lines) {
            if (validator.validate(line)) {
                validLines.add(line);
            }
        }
        List<Cube> cubes = new ArrayList<>();
        for (String line : validLines) {
            cubes.add(parser.parse(line));
        }
        return cubes;
    }

}
