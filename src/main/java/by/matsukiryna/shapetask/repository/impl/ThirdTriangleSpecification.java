package by.matsukiryna.shapetask.repository.impl;

import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.repository.TriangleSpecification;

public class ThirdTriangleSpecification implements TriangleSpecification {
    @Override
    public boolean specify(Triangle triangle) {
        if (triangle == null) {
            return false;
        }

        boolean pointAFirst = triangle.getPointA().getX() <= 0 && triangle.getPointA().getY() <= 0;
        boolean pointBFirst = triangle.getPointB().getX() <= 0 && triangle.getPointB().getY() <= 0;
        boolean pointCFirst = triangle.getPointC().getX() <= 0 && triangle.getPointC().getY() <= 0;
        return pointAFirst && pointBFirst && pointCFirst;
    }
}
