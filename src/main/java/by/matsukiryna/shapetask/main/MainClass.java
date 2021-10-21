package by.matsukiryna.shapetask.main;

import by.matsukiryna.shapetask.entity.Warehouse;
import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.parser.impl.TriangleParserImpl;
import by.matsukiryna.shapetask.reader.TriangleFileReader;
import by.matsukiryna.shapetask.reader.impl.TriangleFileReaderImpl;
import by.matsukiryna.shapetask.repository.TriangleRepository;

import java.util.List;

public class MainClass {
    private static final String FILE_PATH = "data/triangle.txt";

    public static void main(String[] args) throws ShapeException {
        Warehouse warehouse = Warehouse.getInstance();

        TriangleFileReaderImpl triangleFileReader = new TriangleFileReaderImpl();
        List<String> lines = triangleFileReader.readDataFromFile(FILE_PATH);
        TriangleParserImpl triangleParser = new TriangleParserImpl();
        int[] parseLines = triangleParser.parseLine(lines);
    }
}
