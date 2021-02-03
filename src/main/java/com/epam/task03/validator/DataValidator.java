package com.epam.task03.validator;

public class DataValidator {

    private static final String REGULAR_EXPRESSION_TO_SPLIT_LINE_INTO_NUMBERS = "[[\\s\\p{Punct}]&&[^.]&&[^-]]+";
    private static final String REGULAR_EXPRESSION_TO_VALIDATE_DOUBLE_NUMBERS = "[+-]?\\d+\\.\\d+";
    private static final int NUMBERS_NEEDED_TO_CREATE_CUBE = 4;

    public boolean validate(String line) {
        String[] numbers = line.split(REGULAR_EXPRESSION_TO_SPLIT_LINE_INTO_NUMBERS);
        if (numbers.length != NUMBERS_NEEDED_TO_CREATE_CUBE) {
            return false;
        }
        for (String number : numbers) {
            if (!number.matches(REGULAR_EXPRESSION_TO_VALIDATE_DOUBLE_NUMBERS)) {
                return false;
            }
        }
        double edgeLength = Double.parseDouble(numbers[0]);
        if (edgeLength <= 0) {
            return false;
        }
        return true;
    }
}
