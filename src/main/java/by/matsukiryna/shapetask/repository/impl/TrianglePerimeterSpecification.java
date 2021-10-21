package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleSpecification;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;

public class TrianglePerimeterSpecification implements TriangleSpecification {
    private static final double NULL_PERIMETER = 0;
    private double fromPerimeter;
    private double toPerimeter;

    public TrianglePerimeterSpecification(double fromPerimeter, double toPerimeter) {
        this.fromPerimeter = fromPerimeter;
        this.toPerimeter = toPerimeter;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleCalculationServiceImpl triangleCalculationService = new TriangleCalculationServiceImpl();
        boolean perimeter = (triangleCalculationService.calculateTrianglePerimeter(triangle).orElse(NULL_PERIMETER) >= fromPerimeter
                && triangleCalculationService.calculateTrianglePerimeter(triangle).orElse(NULL_PERIMETER) <= toPerimeter);
        return perimeter;
    }
}
