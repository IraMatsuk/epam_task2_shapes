package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.entity.Warehouse;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class TriangleRepositoryImplTest {
    TriangleRepositoryImpl triangleQueryRepository;
    TriangleRepositoryImpl triangleSortRepository;
    List<Triangle> queryTriangles;
    TriangleCalculationServiceImpl triangleCalculationService;
    Warehouse warehouse;

    @BeforeClass
    public void setUp() {
        triangleCalculationService = new TriangleCalculationServiceImpl();
        warehouse = Warehouse.getInstance();
        triangleQueryRepository = new TriangleRepositoryImpl();
        queryTriangles = List.of(
                new Triangle(new CustomPoint(2.5, 3.4), new CustomPoint(2.5, 6.4), new CustomPoint(6.5, 3.4)),
                new Triangle(new CustomPoint(-1.2, 1.4), new CustomPoint(-2.5, 3.4), new CustomPoint(-1.5, 1.4)),
                new Triangle(new CustomPoint(2.0, 3.0), new CustomPoint(2.9, 4.11), new CustomPoint(9.0, 3.0)),
                new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(3.5, 5.5), new CustomPoint(6.0, 0.0)),
                new Triangle(new CustomPoint(9.5, 33.3), new CustomPoint(0.5, 16.4), new CustomPoint(13.5, 7.4))
                );
        //TODO
       // triangleQueryRepository.add(queryTriangles);
        triangleQueryRepository.add(null);
    }

    @Test
    public void testAdd() {
        triangleCalculationService = new TriangleCalculationServiceImpl();
        warehouse = Warehouse.getInstance();
        triangleQueryRepository = new TriangleRepositoryImpl();
        queryTriangles = List.of(
                new Triangle(new CustomPoint(2.5, 3.4), new CustomPoint(2.5, 6.4), new CustomPoint(6.5, 3.4)),
                new Triangle(new CustomPoint(-1.2, 1.4), new CustomPoint(-2.5, 3.4), new CustomPoint(-1.5, 1.4)),
                new Triangle(new CustomPoint(2.0, 3.0), new CustomPoint(2.9, 4.11), new CustomPoint(9.0, 3.0)),
                new Triangle(new CustomPoint(0.0, 0.0), new CustomPoint(3.5, 5.5), new CustomPoint(6.0, 0.0)),
                new Triangle(new CustomPoint(9.5, 33.3), new CustomPoint(0.5, 16.4), new CustomPoint(13.5, 7.4))
        );
      //  triangleQueryRepository.add(queryTriangles);
        triangleQueryRepository.add(null);
    }

    @Test
    public void testRemove() {
    }

    @Test
    public void testQuery() {
    }

    @Test
    public void testSort() {
    }
}