package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.service.TriangleCalculationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.OptionalDouble;

public class TriangleCalculationServiceImpl implements TriangleCalculationService {
    static final Logger logger = LogManager.getLogger();
    private static final double ROUND_SCALE = 1000;

    @Override
    public OptionalDouble calculateTrianglePerimeter(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return OptionalDouble.empty();
        }

        double[] triangleSides = calculateTriangleSides(triangle);
        double perimeter = 0;

        for (double side : triangleSides) {
            perimeter += side;
        }
        perimeter = roundDouble(perimeter);
        logger.info("Triangle perimeter with ID " + triangle.getTriangleId() + " is " + perimeter);
        return OptionalDouble.of(perimeter);
    }

    @Override
    public OptionalDouble calculateTriangleArea(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return OptionalDouble.empty();
        }
        double triangleArea = Math.abs((triangle.getPointB().getX() - triangle.getPointA().getX()) *
                (triangle.getPointC().getY() - triangle.getPointA().getY()) -
                (triangle.getPointC().getX() - triangle.getPointA().getX()) *
                (triangle.getPointB().getY() - triangle.getPointA().getY()) / 2);

        triangleArea = roundDouble(triangleArea);
        logger.info("Triangle area with ID " + triangle.getTriangleId() + " is " + triangleArea);
        return OptionalDouble.of(triangleArea);
    }

    private double calculateSide(CustomPoint pointA, CustomPoint pointB) {
        double side = roundDouble(Math.hypot(pointB.getX() - pointA.getX(), pointB.getY() - pointA.getY()));
        logger.debug("Side is " + side);
        return side;
    }

    private double[] calculateTriangleSides(Triangle triangle) {
        double sideAB = calculateSide(triangle.getPointA(), triangle.getPointB());
        double sideBC = calculateSide(triangle.getPointB(), triangle.getPointC());
        double sideAC = calculateSide(triangle.getPointA(), triangle.getPointC());
        return new double[]{sideAB, sideBC, sideAC};
    }

    private double roundDouble(double value) {
        return Math.round(value * ROUND_SCALE) / ROUND_SCALE;
    }
}
