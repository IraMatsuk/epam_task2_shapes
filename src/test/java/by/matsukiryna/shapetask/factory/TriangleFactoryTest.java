package by.matsukiryna.shapetask.factory;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.exception.TriangleException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleFactoryTest {
    TriangleFactory triangleFactory;

    @BeforeClass
    public void setUp() {
        triangleFactory = new TriangleFactory();
    }

    @Test
    public void testCreateTriangleList() throws TriangleException {
        List<double[]> doubleList = List.of(new double[]{2.5, 3.4, 2.5, 6.4, 6.5, 3.4});
        List<Triangle> actual = triangleFactory.createTriangleList(doubleList);
        List<Triangle> expected = List.of(new Triangle(
                new CustomPoint(2.5, 3.4),
                new CustomPoint(2.5, 6.4),
                new CustomPoint(6.5, 3.4)));
        assertEquals(actual, expected);
    }

    @Test
    public void testCreateTriangle() throws TriangleException {
        double[] doubleArr = {2.3, 1, 2.0, 2, 3.5, 1};
        Triangle actual = triangleFactory.createTriangle(doubleArr);
        Triangle expected = new Triangle(
                new CustomPoint(2.3, 1),
                new CustomPoint(2.0, 2),
                new CustomPoint(3.5, 1));
        assertEquals(actual, expected);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testCreateTriangleNullArray() throws TriangleException {
        triangleFactory.createTriangle(null);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testCreateTriangleWhenDoubleListIsEmpty() throws TriangleException {
        double[] emptyList = {};
        triangleFactory.createTriangle(emptyList);
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testCreateTriangleWhenElementsInArrayLessThatSix() throws TriangleException {
        triangleFactory.createTriangle(new double[]{1.2, 2.2, 4.3, 5.1});
    }

    @Test(expectedExceptions = TriangleException.class)
    public void testCreateTriangleWhenElementsInArrayMoreThatSix() throws TriangleException {
        triangleFactory.createTriangle(new double[]{1.2, 2.2, 4.3, 5.1, 3.5, 1.1, 3.6});
    }
}