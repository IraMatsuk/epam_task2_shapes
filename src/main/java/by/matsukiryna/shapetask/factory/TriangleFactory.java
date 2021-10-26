package by.matsukiryna.shapetask.factory;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleFactory {
    static final Logger logger = LogManager.getLogger();
    private static final int VALID_AMOUNT_OF_COORDINATE = 6;
    private CustomPoint pointA;
    private CustomPoint pointB;
    private CustomPoint pointC;

    public List<Triangle> createTriangleList(List<double[]> doubleArraysList) throws ShapeException {
        List<Triangle> triangleArrayList = new ArrayList<>();
        if (doubleArraysList == null || doubleArraysList.isEmpty()) {
            throw new ShapeException("Given list is null or hasn't any arrays");
        }

        if (!TriangleValidator.isTriangleValid(pointA, pointB, pointC)) {
            throw new ShapeException("Invalid points for triangle" + pointA + " " + pointB + " " + pointC);
        }

        for (double[] coordinateArray : doubleArraysList) {
            Triangle triangle = createTriangle(coordinateArray);
            triangleArrayList.add(triangle);
        }
        logger.info("Creating Triangle list is successful");
        return triangleArrayList;
    }

    public Triangle createTriangle(double[] coordinateArray) throws ShapeException {
        if (coordinateArray == null || coordinateArray.length != VALID_AMOUNT_OF_COORDINATE) {
            throw new ShapeException(String.format("Parameters %s aren't correct", Arrays.toString(coordinateArray)));
        }
        var triangle = new Triangle(new CustomPoint(coordinateArray[0], coordinateArray[1]),
                new CustomPoint(coordinateArray[2], coordinateArray[3]),
                new CustomPoint(coordinateArray[4], coordinateArray[5]));
        logger.info("Creating Triangle is successful: " + triangle);
        return triangle;
    }
}
