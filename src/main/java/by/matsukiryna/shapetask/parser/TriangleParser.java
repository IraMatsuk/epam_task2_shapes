package by.matsukiryna.shapetask.parser;

import by.matsukiryna.shapetask.exception.TriangleException;

import java.util.List;

public interface TriangleParser {
    double[] parseLine(List<String> line) throws TriangleException;
}
