package by.matsukiryna.shapetask.comparator;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;

import java.util.Comparator;
import java.util.OptionalDouble;

public class TrianglePerimeterComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        TriangleCalculationServiceImpl calculationService = new TriangleCalculationServiceImpl();
        OptionalDouble perimeter1 = calculationService.calculateTrianglePerimeter(o1);
        OptionalDouble perimeter2 = calculationService.calculateTrianglePerimeter(o2);
        return Double.compare(perimeter1.getAsDouble(), perimeter2.getAsDouble());
    }
}
