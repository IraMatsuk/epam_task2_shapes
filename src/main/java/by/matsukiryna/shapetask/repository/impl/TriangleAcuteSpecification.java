package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleSpecification;
import by.matsukiryna.shapetask.service.impl.TriangleServiceImpl;

public class TriangleAcuteSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        TriangleServiceImpl triangleService = new TriangleServiceImpl();
        return triangleService.isTriangleAcute(triangle);
    }
}
