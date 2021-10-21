package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleSpecification;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;

public class TriangleAreaSpecification implements TriangleSpecification {
    private static final double NULL_VALUE_AREA = 0;
    private double fromArea;
    private double toArea;

    public TriangleAreaSpecification(double fromArea, double toArea) {
        this.fromArea = fromArea;
        this.toArea = toArea;
    }

    @Override
    public boolean specify(Triangle triangle) {
        TriangleCalculationServiceImpl calculationService = new TriangleCalculationServiceImpl();
        boolean triangleArea = calculationService.calculateTriangleArea(triangle).orElse(NULL_VALUE_AREA) >= fromArea
                && calculationService.calculateTriangleArea(triangle).orElse(NULL_VALUE_AREA) <= toArea;
        return triangleArea;
    }
}
