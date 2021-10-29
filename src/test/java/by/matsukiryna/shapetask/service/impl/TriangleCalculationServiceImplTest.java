package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TriangleCalculationServiceImplTest {
    TriangleCalculationServiceImpl triangleCalculationService;
    Triangle triangle;

    @BeforeMethod
    public void setUp() {
        triangleCalculationService = new TriangleCalculationServiceImpl();
        triangle = new Triangle(new CustomPoint(1.5, 3.5), new CustomPoint(3.0, 4.0), new CustomPoint(4.8, 3.5));
    }

    @Test
    public void testCalculateTriangleArea() {
        double actual = triangleCalculationService.calculateTriangleArea(triangle).getAsDouble();
        double expected = 0.82;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTrianglePerimeter() {
        double actual = triangleCalculationService.calculateTrianglePerimeter(triangle).getAsDouble();
        double expected = 6.75;
        assertEquals(actual, expected);
    }

    @Test
    public void testCalculateTrianglePerimeterWhenTriangleIsNull() {
        boolean actual = triangleCalculationService.calculateTrianglePerimeter(null).isEmpty();
        assertTrue(actual);
    }
}