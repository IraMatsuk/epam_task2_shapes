package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class TriangleServiceImpl implements TriangleService {
    static final Logger logger = LogManager.getLogger();
    private static final double ROUND_SCALE = 1000;

    @Override
    public boolean isRightTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }

        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);
        boolean rightTriangle = sides[2] == roundDouble(Math.hypot(sides[0], sides[1]));
        logger.info(() -> rightTriangle ? "Triangle " + triangle.getTriangleId()
                + " is right" : "Triangle " + triangle.getTriangleId() + " isn't right");
        return rightTriangle;
    }

    @Override
    public boolean isIsoscelesTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }

        double[] sides = calculateTriangleSides(triangle);
        boolean isoscelesTriangle = sides[0] == sides[1] ||
                sides[0] == sides[2] ||
                sides[1] == sides[2];
        logger.info(() -> isoscelesTriangle ? "Triangle " + triangle.getTriangleId()
                + " is isosceles" : "Triangle " + triangle.getTriangleId() + " isn't isosceles");
        return isoscelesTriangle;
    }

    @Override
    public boolean isTriangleEquilateral(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        boolean equilateralTriangle = sides[0] == sides[1]
                && sides[0] == sides[2]
                && sides[1] == sides[2];
        logger.info(() -> equilateralTriangle ? "Triangle " + triangle.getTriangleId()
                + " is equilateral" : "Triangle " + triangle.getTriangleId() + " isn't equilateral");
        return equilateralTriangle;
    }

    @Override
    public boolean isTriangleAcute(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);
        boolean acuteTriangle = sides[2] < roundDouble(Math.hypot(sides[0], sides[1]));
        logger.info(() -> acuteTriangle ? "Triangle " + triangle.getTriangleId()
                + " is acute" : "Triangle " + triangle.getTriangleId() + " isn't acute");
        return acuteTriangle;
    }

    @Override
    public boolean isTriangleObtuse(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }
        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);
        boolean obtuseTriangle = sides[2] > roundDouble(Math.hypot(sides[0], sides[1]));
        logger.info(() -> obtuseTriangle ? "Triangle " + triangle.getTriangleId()
                + " is obtuse" : "Triangle " + triangle.getTriangleId() + " isn't obtuse");
        return obtuseTriangle;
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

    @Override
    public boolean isTriangle(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        boolean existTriangle = (sides[0] + sides[1]) > sides[2]
                && (sides[1] + sides[2]) > sides[0]
                && (sides[0] + sides[2]) > sides[1];
        logger.info(() -> existTriangle ? "Triangle " + triangle.getTriangleId()
                + " is exist" : "Triangle " + triangle.getTriangleId() + " isn't exist");
        return existTriangle;
    }
}
