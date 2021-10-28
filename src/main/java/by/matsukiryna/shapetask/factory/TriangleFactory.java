package by.matsukiryna.shapetask.factory;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.exception.TriangleException;
import by.matsukiryna.shapetask.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleFactory {
    static final Logger logger = LogManager.getLogger();
    private static final int VALID_AMOUNT_OF_COORDINATE = 6;
    private static final int ZERO_COORDINATE_INDEX = 0;
    private static final int FIRST_COORDINATE_INDEX = 1;
    private static final int SECOND_COORDINATE_INDEX = 2;
    private static final int THIRD_COORDINATE_INDEX = 3;
    private static final int FORTH_COORDINATE_INDEX = 4;
    private static final int FIFTH_COORDINATE_INDEX = 5;

    public List<Triangle> createTriangleList(List<double[]> doubleArraysList) throws TriangleException {
        List<Triangle> triangleArrayList = new ArrayList<>();
        if (doubleArraysList == null || doubleArraysList.isEmpty()) {
            throw new TriangleException("Given list is null or hasn't any arrays");
        }

        for (double[] coordinateArray : doubleArraysList) {
            Triangle triangle = createTriangle(coordinateArray);
            triangleArrayList.add(triangle);
        }
        return triangleArrayList;
    }

    public Triangle createTriangle(double[] coordinateArray) throws TriangleException {
        if (coordinateArray == null || coordinateArray.length != VALID_AMOUNT_OF_COORDINATE) {
            throw new TriangleException(String.format("Parameters %s are not correct", Arrays.toString(coordinateArray)));
        }

        var point1 = new CustomPoint(coordinateArray[ZERO_COORDINATE_INDEX], coordinateArray[FIRST_COORDINATE_INDEX]);
        var point2 = new CustomPoint(coordinateArray[SECOND_COORDINATE_INDEX], coordinateArray[THIRD_COORDINATE_INDEX]);
        var point3 = new CustomPoint(coordinateArray[FORTH_COORDINATE_INDEX], coordinateArray[FIFTH_COORDINATE_INDEX]);

        if (!TriangleValidator.isTriangleValid(point1, point2, point3)) {
            logger.error("Invalid points for triangle" + Arrays.toString(coordinateArray));
            throw new TriangleException("Invalid points for triangle" + point1 + " " + point2 + " " + point3);
        }

        Triangle triangle = new Triangle(point1, point2, point3);
        logger.info("Triangle was created successfully: " + triangle);
        return triangle;
    }
}
