package by.matsukiryna.shapetask.validator;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleValidator {
    static final Logger logger = LogManager.getLogger();

    private TriangleValidator() {

    }

    public static boolean isTriangleValid(CustomPoint pointA, CustomPoint pointB, CustomPoint pointC) {
        return ((pointC.getX() - pointA.getX()) * (pointB.getY() - pointA.getY()) -
                (pointC.getY() - pointA.getY()) * (pointB.getX() - pointA.getX()) != 0);
    }

    public static boolean isTriangleValid(Triangle triangle) {
        CustomPoint pointA = triangle.getPointA();
        CustomPoint pointB = triangle.getPointB();
        CustomPoint pointC = triangle.getPointC();
        return isTriangleValid(pointA, pointB, pointC);
    }
}