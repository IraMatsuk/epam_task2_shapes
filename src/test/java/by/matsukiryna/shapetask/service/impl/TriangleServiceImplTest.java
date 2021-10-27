package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.exception.ShapeException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {
    TriangleServiceImpl triangleService;
    Triangle triangle;

    @BeforeClass
    public void setUp() {
        triangleService = new TriangleServiceImpl();
    }

    @DataProvider(name = "rightTriangleData")
    public Object[][] rightTriangleData() throws ShapeException {
        return new Object[][]{
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.536, 3), new CustomPoint(1.536, 7), new CustomPoint(5, 5))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(13.0, 13.0), new CustomPoint(4.34, 8.0), new CustomPoint(4.34, 18.0))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(4.5, 4.5), new CustomPoint(6.5, 6.0))), false},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), false}
        };
    }

    @Test(dataProvider = "rightTriangleData")
    public void testIsRightTriangle(boolean actualResult, boolean expectedResult) {
        assertEquals(actualResult, expectedResult, String.format("The triangle is%s right.", expectedResult ? " not " : ""));
    }

    @Test
    public void testIsIsoscelesTriangle() {
    }

    @Test
    public void testIsTriangleEquilateral() {
    }

    @Test
    public void testIsTriangleAcute() {
    }

    @Test
    public void testIsTriangleObtuse() {
    }

    @Test
    public void testIsTriangle() {
    }
}