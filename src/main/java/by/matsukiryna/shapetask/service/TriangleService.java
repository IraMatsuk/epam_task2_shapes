package by.matsukiryna.shapetask.service;

import by.matsukiryna.shapetask.entity.Triangle;

public interface TriangleService {
    boolean isRightTriangle(Triangle triangle);

    boolean isIsoscelesTriangle(Triangle triangle);

    boolean isTriangleEquilateral(Triangle triangle);

    boolean isTriangleAcute(Triangle triangle);

    boolean isTriangleObtuse(Triangle triangle);

    boolean isTriangle(Triangle triangle);
}
