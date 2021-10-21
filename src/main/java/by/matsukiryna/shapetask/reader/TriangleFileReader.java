package by.matsukiryna.shapetask.reader;

import by.matsukiryna.shapetask.exception.ShapeException;

import java.util.List;

public interface TriangleFileReader {
    List<String> readDataFromFile(String filePath) throws ShapeException;
}
