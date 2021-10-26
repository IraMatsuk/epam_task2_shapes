package by.matsukiryna.shapetask.factory;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.exception.ShapeException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class TriangleFactoryTest {
    TriangleFactory triangleFactory;

    @BeforeClass
    public void setUp() {
        triangleFactory = new TriangleFactory();
    }

    @Test
    public void testCreateTriangleList() throws ShapeException {
        List<double[]> doubleList = List.of(new double[]{2.5, 3.4, 2.5, 6.4, 6.5, 3.4});
        List<Triangle> actual = triangleFactory.createTriangleList(doubleList);
        List<Triangle> expected = List.of(
                new Triangle(new CustomPoint(2.5, 3.4), new CustomPoint(2.5, 6.4), new CustomPoint(6.5, 3.4))
        );
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateTriangle() {
    }
}