package by.matsukiryna.shapetask.main;

import by.matsukiryna.shapetask.comparator.TrianglePerimeterComparator;
import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.entity.TriangleParameter;
import by.matsukiryna.shapetask.entity.Warehouse;
import by.matsukiryna.shapetask.exception.TriangleException;
import by.matsukiryna.shapetask.factory.TriangleFactory;
import by.matsukiryna.shapetask.observer.impl.TriangleObserverImpl;
import by.matsukiryna.shapetask.parser.impl.TriangleParserImpl;
import by.matsukiryna.shapetask.reader.impl.TriangleFileReaderImpl;
import by.matsukiryna.shapetask.repository.TriangleRepository;
import by.matsukiryna.shapetask.repository.TriangleSpecification;
import by.matsukiryna.shapetask.repository.impl.TrianglePerimeterSpecification;
import by.matsukiryna.shapetask.repository.impl.TriangleRepositoryImpl;
import by.matsukiryna.shapetask.service.impl.TriangleCalculationServiceImpl;
import by.matsukiryna.shapetask.service.impl.TriangleServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MainClass {
    static final Logger logger = LogManager.getLogger();
    private static final String FILE_PATH = "data/triangle.txt";

    public static void main(String[] args) throws TriangleException {
        TriangleFileReaderImpl triangleFileReader = new TriangleFileReaderImpl();
        List<String> lines = triangleFileReader.readDataFromFile(FILE_PATH);
        TriangleParserImpl triangleParser = new TriangleParserImpl();
        double[] parsedLines = triangleParser.parseLine(lines);
        TriangleFactory triangleFactory = new TriangleFactory();
        List<Triangle> triangles = triangleFactory.createTriangleList(Arrays.asList(parsedLines));
        triangles.stream()
                .collect(Collectors.toList());

        TriangleCalculationServiceImpl triangleCalculationService = new TriangleCalculationServiceImpl();
        triangles.forEach(triangleCalculationService::calculateTriangleArea);
        triangles.forEach(triangleCalculationService::calculateTrianglePerimeter);

        TriangleServiceImpl triangleService = new TriangleServiceImpl();
        triangles.forEach(triangleService::isRightTriangle);

        Warehouse warehouse = Warehouse.getInstance();
        for (Triangle triangle : triangles) {
            OptionalDouble area = triangleCalculationService.calculateTriangleArea(triangle);
            OptionalDouble perimeter = triangleCalculationService.calculateTrianglePerimeter(triangle);
            TriangleParameter triangleParameter = new TriangleParameter(perimeter.getAsDouble(), area.getAsDouble());
            warehouse.put(triangle.getTriangleId(), triangleParameter);
        }
        TriangleObserverImpl triangleObserver1 = new TriangleObserverImpl();
        TriangleObserverImpl triangleObserver2 = new TriangleObserverImpl();

        Triangle triangle = triangles.get(0);
        triangle.attach(triangleObserver1);
        triangle.attach(triangleObserver2);
        logger.info(warehouse.get(triangle.getTriangleId()));
        triangle.setPointA(new CustomPoint(1.2, 2.4));
        Optional<TriangleParameter> updateParameter = warehouse.get(triangle.getTriangleId());
        logger.info("Update parameters: " + updateParameter);

        TriangleRepository triangleRepository = TriangleRepositoryImpl.getInstance();
        triangleRepository.addAll(triangles);
        List<Triangle> sortedByPerimeter = triangleRepository.sort(new TrianglePerimeterComparator());
        logger.info("After sorting by perimeter: " + sortedByPerimeter);

        TriangleSpecification specification1 = new TrianglePerimeterSpecification(1, 20);
        List<Triangle> selectByPerimeter = triangleRepository.query(specification1);
        logger.info("Query select from 1 to 20: " + selectByPerimeter);
    }
}
