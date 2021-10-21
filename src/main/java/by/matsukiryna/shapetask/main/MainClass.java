package by.matsukiryna.shapetask.main;

import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.parser.impl.TriangleParserImpl;
import by.matsukiryna.shapetask.reader.TriangleFileReader;
import by.matsukiryna.shapetask.reader.impl.TriangleFileReaderImpl;

import java.util.List;

public class MainClass {
    private static final String FILE_PATH = "data/triangle.txt";

    public static void main(String[] args) throws ShapeException {
        TriangleFileReaderImpl triangleFileReader = new TriangleFileReaderImpl();
        List<String> lines = triangleFileReader.readDataFromFile(FILE_PATH);
        TriangleParserImpl triangleParser = new TriangleParserImpl();
        double[] parseLines = triangleParser.parseLine(lines.toString());
    }
}
