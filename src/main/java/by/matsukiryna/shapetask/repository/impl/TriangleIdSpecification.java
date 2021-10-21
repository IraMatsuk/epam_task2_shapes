package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleSpecification;

public class TriangleIdSpecification implements TriangleSpecification {
    private int triangleId;

    public TriangleIdSpecification(int triangleId) {
        this.triangleId = triangleId;
    }

    @Override
    public boolean specify(Triangle triangle) {
        boolean result = triangle.getTriangleId() == triangleId;
        return result;
    }
}
