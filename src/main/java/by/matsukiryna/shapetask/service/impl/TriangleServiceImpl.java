package by.matsukiryna.shapetask.service.impl;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.service.TriangleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class TriangleServiceImpl implements TriangleService {
    static final Logger logger = LogManager.getLogger();
    private static final int FIRST_SIDE_INDEX = 0;
    private static final int SECOND_SIDE_INDEX = 1;
    private static final int THIRD_SIDE_INDEX = 2;

    @Override
    public boolean isRightTriangle(Triangle triangle) {
        if (triangle == null) {
            logger.warn("Triangle is null.");
            return false;
        }

        double[] sides = calculateTriangleSides(triangle);
        Arrays.sort(sides);
        boolean rightTriangle = sides[THIRD_SIDE_INDEX] == roundDouble(Math.hypot(sides[FIRST_SIDE_INDEX], sides[SECOND_SIDE_INDEX]));
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
        boolean isoscelesTriangle = Double.compare(sides[FIRST_SIDE_INDEX], sides[SECOND_SIDE_INDEX]) == 0
                || Double.compare(sides[SECOND_SIDE_INDEX],sides[THIRD_SIDE_INDEX]) == 0
                || Double.compare(sides[FIRST_SIDE_INDEX],sides[THIRD_SIDE_INDEX]) == 0;
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
        boolean equilateralTriangle = Double.compare(sides[FIRST_SIDE_INDEX], sides[SECOND_SIDE_INDEX]) == 0
                && Double.compare(sides[SECOND_SIDE_INDEX],sides[THIRD_SIDE_INDEX]) == 0
                && Double.compare(sides[FIRST_SIDE_INDEX],sides[THIRD_SIDE_INDEX]) == 0;
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
        boolean acuteTriangle = sides[THIRD_SIDE_INDEX] < roundDouble(Math.hypot(sides[FIRST_SIDE_INDEX], sides[SECOND_SIDE_INDEX]));
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
        boolean obtuseTriangle = sides[THIRD_SIDE_INDEX] > roundDouble(Math.hypot(sides[FIRST_SIDE_INDEX], sides[SECOND_SIDE_INDEX]));
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
        BigDecimal roundDoubleResult = new BigDecimal(value);
        roundDoubleResult = roundDoubleResult.setScale(2, RoundingMode.HALF_UP);
        return roundDoubleResult.doubleValue();
    }

    @Override
    public boolean isTriangle(Triangle triangle) {
        double[] sides = calculateTriangleSides(triangle);
        boolean existTriangle = (sides[FIRST_SIDE_INDEX] + sides[SECOND_SIDE_INDEX]) > sides[THIRD_SIDE_INDEX]
                && (sides[SECOND_SIDE_INDEX] + sides[THIRD_SIDE_INDEX]) > sides[FIRST_SIDE_INDEX]
                && (sides[FIRST_SIDE_INDEX] + sides[THIRD_SIDE_INDEX]) > sides[SECOND_SIDE_INDEX];
        logger.info(() -> existTriangle ? "Triangle " + triangle.getTriangleId()
                + " is exist" : "Triangle " + triangle.getTriangleId() + " isn't exist");
        return existTriangle;
    }
}
