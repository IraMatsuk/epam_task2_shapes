package by.matsukiryna.shapetask.main;

import by.matsukiryna.shapetask.entity.CustomPoint;
import by.matsukiryna.shapetask.entity.Triangle;
import by.matsukiryna.shapetask.entity.Warehouse;
import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.factory.TriangleFactory;
import by.matsukiryna.shapetask.parser.impl.TriangleParserImpl;
import by.matsukiryna.shapetask.reader.TriangleFileReader;
import by.matsukiryna.shapetask.reader.impl.TriangleFileReaderImpl;
import by.matsukiryna.shapetask.repository.TriangleRepository;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class MainClass {
    private static final String FILE_PATH = "data/triangle.txt";

    public static void main(String[] args) throws ShapeException {
        Warehouse warehouse = Warehouse.getInstance();

        TriangleFileReaderImpl triangleFileReader = new TriangleFileReaderImpl();
        List<String> lines = triangleFileReader.readDataFromFile(FILE_PATH);
        TriangleParserImpl triangleParser = new TriangleParserImpl();
        double[] parsedLines = triangleParser.parseLine(lines);
        TriangleFactory triangleFactory = new TriangleFactory();
        Triangle triangle = triangleFactory.createTriangle(parsedLines);
        CustomPoint customPoint = new CustomPoint();

    }
}
