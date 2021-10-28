package by.matsukiryna.shapetask.service;

import by.matsukiryna.shapetask.entity.Triangle;

import java.util.OptionalDouble;

public interface TriangleCalculationService {
    OptionalDouble calculateTrianglePerimeter(Triangle triangle);

    OptionalDouble calculateTriangleArea(Triangle triangle);
}
