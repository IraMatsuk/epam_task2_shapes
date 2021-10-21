package by.matsukiryna.shapetask.observer.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.entity.TriangleParameter;
import by.matsukiryna.shapetask.entity.Warehouse;
import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.observer.TriangleEvent;
import by.matsukiryna.shapetask.observer.TriangleObserver;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleObserverImpl implements TriangleObserver {
    static final Logger logger = LogManager.getLogger();

    @Override
    public void updateParameters(TriangleEvent event) throws ShapeException {
        var warehouse = Warehouse.getInstance();
        var calculationService = new TriangleCalculationServiceImpl();
        Triangle triangle = event.getSource();
        double perimeter = calculationService.calculateTrianglePerimeter(triangle)
                .orElseThrow(() -> new ShapeException("This triangle is null"));
        double area = calculationService.calculateTriangleArea(triangle)
                .orElseThrow(() -> new ShapeException("This triangle is null"));
        TriangleParameter triangleParameters = new TriangleParameter(perimeter, area);
        warehouse.put(triangle.getTriangleId(), triangleParameters);
        logger.info("Parameters of the triangle were updated", triangle.getTriangleId());
    }
}
