package by.matsukiryna.shapetask.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleStringValidatorTest {

    @DataProvider(name = "stringValidator")
    public Object[][] stringValidator() {
        return new Object[][]{
                {"2.5 3.4  2.5 6.4  6.5 3.4", true},
                {"0 0         2.5 4.33    5 0", true},
                {"2.3 hello 44 1 0 11.6", false},
                {"2.3 44   1 0 11.6", false},
        };
    }

    @Test(dataProvider = "stringValidator")
    public void testIsLineValidate(String line, boolean expected) {
        boolean actual = TriangleStringValidator.isLineValidate(line);
        assertEquals(actual, expected);
    }
}