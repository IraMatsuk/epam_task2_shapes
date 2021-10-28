package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleServiceImplTest {
    TriangleServiceImpl triangleService;

    @BeforeClass
    public void setUp() {
        triangleService = new TriangleServiceImpl();
    }

    @DataProvider(name = "rightTriangleData")
    public Object[][] rightTriangleData() {
        return new Object[][]{
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.536, 3), new CustomPoint(1.536, 7), new CustomPoint(5, 5))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(13.0, 13.0), new CustomPoint(4.34, 8.0), new CustomPoint(4.34, 18.0))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(4.5, 4.5), new CustomPoint(6.5, 6.0))), false},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), false}
        };
    }

    @DataProvider(name = "isoscelesTriangleData")
    public Object[][] isoscelesTriangleData() {
        return new Object[][]{
                {triangleService.isIsoscelesTriangle(new Triangle(new CustomPoint(0.0, 3.0), new CustomPoint(-2.0, -3.0), new CustomPoint(-6.0, 1.0))), true},
                {triangleService.isIsoscelesTriangle(new Triangle(new CustomPoint(13.0, 13.0), new CustomPoint(4.34, 8.0), new CustomPoint(4.34, 18.0))), true},
                {triangleService.isIsoscelesTriangle(new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(4.5, 4.5), new CustomPoint(6.5, 6.0))), false},
                {triangleService.isIsoscelesTriangle(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), false}
        };
    }

    @DataProvider(name = "equilateralTriangleData")
    public Object[][] equilateralTriangleData() {
        return new Object[][]{
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.536, 3), new CustomPoint(1.536, 7), new CustomPoint(5, 5))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(13.0, 13.0), new CustomPoint(4.34, 8.0), new CustomPoint(4.34, 18.0))), true},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(4.5, 4.5), new CustomPoint(6.5, 6.0))), false},
                {triangleService.isTriangleEquilateral(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), false}
        };
    }

    @DataProvider(name = "acuteTriangleData")
    public Object[][] acuteTriangleData() {
        return new Object[][]{
                {triangleService.isTriangleAcute(new Triangle(new CustomPoint(1.0, 1.0), new CustomPoint(1.5, 2.8), new CustomPoint(2.2, 1.2))), true},
                {triangleService.isTriangleAcute(new Triangle(new CustomPoint(2.0, 2.0), new CustomPoint(3.5, 2.6), new CustomPoint(3.4, 1.0))), true},
                {triangleService.isTriangleAcute(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), false},
                {triangleService.isTriangleAcute(new Triangle(new CustomPoint(10.2, 14.4), new CustomPoint(0.8, 0.9), new CustomPoint(11.5, 5.3))), false}
        };
    }

    @DataProvider(name = "obtuseTriangleData")
    public Object[][] obtuseTriangleData() {
        return new Object[][]{
                {triangleService.isTriangleObtuse(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), true},
                {triangleService.isTriangleObtuse(new Triangle(new CustomPoint(10.2, 14.4), new CustomPoint(0.8, 0.9), new CustomPoint(11.5, 5.3))), true},
                {triangleService.isTriangleObtuse(new Triangle(new CustomPoint(1.0, 1.0), new CustomPoint(1.5, 2.8), new CustomPoint(2.2, 1.2))), false},
                {triangleService.isTriangleObtuse(new Triangle(new CustomPoint(2.0, 2.0), new CustomPoint(3.5, 2.6), new CustomPoint(3.4, 1.0))), false}
        };
    }

    @DataProvider(name = "triangleData")
    public Object[][] triangleData() {
        return new Object[][]{
                {triangleService.isTriangle(new Triangle(new CustomPoint(1.0, 2.0), new CustomPoint(3.7, 4.4), new CustomPoint(16.5, 8.3))), true},
                {triangleService.isTriangle(new Triangle(new CustomPoint(100.1, 99.9), new CustomPoint(0.89, 0.99), new CustomPoint(50.45, 69.99))), true},
                {triangleService.isTriangle(new Triangle(new CustomPoint(1.0, 1.0), new CustomPoint(1.0, 1.0), new CustomPoint(1.0, 1.0))), false},
                {triangleService.isTriangle(new Triangle(new CustomPoint(2.0, 2.0), new CustomPoint(0.0, 0.0), new CustomPoint(2.0, 2.0))), false}
        };
    }

    @Test(dataProvider = "rightTriangleData")
    public void testIsRightTriangle(boolean actualResult, boolean expectedResult) {
        assertEquals(actualResult, expectedResult);
    }

    @Test(dataProvider = "isoscelesTriangleData")
    public void testIsIsoscelesTriangle(boolean actual, boolean expected) {
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "equilateralTriangleData")
    public void testIsTriangleEquilateral(boolean actual, boolean expected) {
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "acuteTriangleData")
    public void testIsTriangleAcute(boolean actual, boolean expected) {
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "obtuseTriangleData")
    public void testIsTriangleObtuse(boolean actual, boolean expected) {
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "triangleData")
    public void testIsTriangle(boolean actual, boolean expected) {
        assertEquals(actual, expected);
    }
}
