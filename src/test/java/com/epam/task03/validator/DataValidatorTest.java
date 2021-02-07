package com.epam.task03.validator;

import org.junit.Assert;
import org.junit.Test;

public class DataValidatorTest {

    private final DataValidator validator = new DataValidator();
    private static final String VALID_DATA = "2.0 0.5 3.0 0.5";
    private static final String NEGATIVE_FIRST_NUMBER = "-1.0 2.3 4.5 6.7";
    private static final String CONTAINS_INVALID_NUMBERS = "3.5 2.k3 6.7 2.1";
    private static final String INVALID_AMOUNT_OF_NUMBERS = "2.0 0.0 0.0";
    private static final String DIFFERENT_DELIMITERS = "2.0,0.0;0.0:0.0";

    @Test
    public void testValidateWithValidDataShouldSucceed() {
        Assert.assertTrue(validator.validate(VALID_DATA));
    }

    @Test
    public void testValidateWithNegativeFirstNumberShouldSucceed() {
        Assert.assertFalse(validator.validate(NEGATIVE_FIRST_NUMBER));
    }

    @Test
    public void testValidateWithInvalidNumbersShouldSucceed() {
        Assert.assertFalse(validator.validate(CONTAINS_INVALID_NUMBERS));
    }

    @Test
    public void testValidateWithInvalidAmountOfNumbersShouldSucceed() {
        Assert.assertFalse(validator.validate(INVALID_AMOUNT_OF_NUMBERS));
    }

    @Test
    public void testValidateWithDifferentDelimitersShouldSucceed() {
        Assert.assertTrue(validator.validate(DIFFERENT_DELIMITERS));
    }
}
