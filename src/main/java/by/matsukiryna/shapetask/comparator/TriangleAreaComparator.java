package by.matsukiryna.shapetask.comparator;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;

import java.util.Comparator;
import java.util.OptionalDouble;

public class TriangleAreaComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        TriangleCalculationServiceImpl calculationService = new TriangleCalculationServiceImpl();
        OptionalDouble area1 = calculationService.calculateTriangleArea(o1);
        OptionalDouble area2 = calculationService.calculateTriangleArea(o2);
        return Double.compare(area1.getAsDouble(), area2.getAsDouble());
    }
}
