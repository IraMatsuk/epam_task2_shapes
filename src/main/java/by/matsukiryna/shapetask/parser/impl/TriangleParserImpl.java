package by.matsukiryna.shapetask.parser.impl;

import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleParserImpl implements TriangleParser {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_DELIMITER = "\\s+";

    @Override
    public double[] parseLine(List<String> lines) throws ShapeException {
        if (lines == null || lines.size() == 0) {
            logger.error("Input list is empty or size is zero.");
            throw new ShapeException("Input list is empty or size is zero." + lines);
        }
        String listToStr = lines.stream()
                                .map(n -> String.valueOf(n))
                                .collect(Collectors.joining());
        logger.info("Read from file: " + listToStr);

        String[] strDoubles = listToStr.split(REGEX_DELIMITER);
        double[] result = Arrays.stream(strDoubles)
                                .mapToDouble(Double::parseDouble)
                                .toArray();
        logger.info("Result of parsing line: " + Arrays.toString(result));
        return result;
    }
}
