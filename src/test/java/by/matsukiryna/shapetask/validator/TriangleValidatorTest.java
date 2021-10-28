package by.matsukiryna.shapetask.validator;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TriangleValidatorTest {

    @DataProvider(name = "triangleData")
    public Object[][] triangleData() {
        return new Object[][]{
                {new Triangle(new CustomPoint(1.536, 3), new CustomPoint(1.536, 7), new CustomPoint(5, 5)), true},
                {new Triangle(new CustomPoint(13.0, 13.0), new CustomPoint(4.34, 8.0), new CustomPoint(4.34, 18.0)), true},
                {new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(0.0, 0.0), new CustomPoint(6.0, 6.0)), false},
                {new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(2.0, 2.0), new CustomPoint(2.0, 2.0)), false}
        };
    }

    @Test(dataProvider = "triangleData")
    public void testIsTriangleValid(Triangle triangle, boolean expected) {
        boolean actual = TriangleValidator.isTriangleValid(triangle);
        assertEquals(actual, expected);
    }
}