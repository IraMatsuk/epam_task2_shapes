package by.matsukiryna.shapetask.parser.impl;

import by.matsukiryna.shapetask.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TriangleParserImpl implements TriangleParser {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_DELIMITER= "\\s+";

    @Override
    public double[] parseLine(List<String> line) {
        //TODO
        String listToStr = line.stream()
                .map(n -> String.valueOf(n))
                .collect(Collectors.joining(REGEX_DELIMITER));

        String[] strDoubles = listToStr.split(REGEX_DELIMITER);
        double[] result = Arrays.stream(strDoubles)
                                .mapToDouble(Double::parseDouble)
                                .toArray();
        logger.info("Result of parsing line: " + Arrays.toString(result));
        return result;
    }
}
