package com.epam.task03.parser;

import com.epam.task03.entities.Cube;

public class CubeParser {

    private static final String REGULAR_EXPRESSION_TO_SPLIT_LINE_INTO_NUMBERS = "[[\\s\\p{Punct}]&&[^.]&&[^-]]+";

    public Cube parse(String data) {
        String[] cubeParameters = data.split(REGULAR_EXPRESSION_TO_SPLIT_LINE_INTO_NUMBERS);
            double edgeLength = Double.parseDouble(cubeParameters[0]);
            double xCenter = Double.parseDouble(cubeParameters[1]);
            double yCenter = Double.parseDouble(cubeParameters[2]);
            double zCenter = Double.parseDouble(cubeParameters[3]);
            return new Cube(edgeLength, xCenter, yCenter, zCenter);

    }

}
