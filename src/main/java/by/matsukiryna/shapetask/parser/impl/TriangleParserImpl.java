package by.matsukiryna.shapetask.parser.impl;

import by.matsukiryna.shapetask.exception.ShapeException;
import by.matsukiryna.shapetask.parser.TriangleParser;
import by.matsukiryna.shapetask.validator.TriangleStringValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TriangleParserImpl implements TriangleParser {
    static final Logger logger = LogManager.getLogger();
    private static final String REGEX_DELIMITER= "\\s?(\\d+)";
    private static final String VALID_TRIANGLE_DATA_REGEX = "^-?\\d+(\\.\\d+)?(\\s+-?\\d+(\\.\\d+)?){5}$";

    @Override
    public int[] parseLine(List<String> lines) throws ShapeException {
        //TODO
        if (lines == null || lines.size() == 0) {
           logger.error("Input list is empty or size is zero.");
           throw new ShapeException("Input list is empty or size is zero." + lines);
        }
        Pattern pattern = Pattern.compile(REGEX_DELIMITER);
        ArrayList<Integer> integers = new ArrayList<>();
        for (String s : lines) {
            if (TriangleStringValidator.isLineValidate(s)) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    integers.add(Integer.valueOf(matcher.group(1)));
                    logger.debug(matcher.group(1));
                }
            }
        }

        if (integers.size() == 0) {
            logger.error("There was no correct information in the data file");
            throw new ShapeException("There was no correct information in the data file");
        }
        int[] result = new int[integers.size()];
        for (int i = 0; i < integers.size(); i++) {
            result[i] = integers.get(i);
        }
        logger.info("double[] created" + Arrays.toString(result));
        return result;
//        String listToStr = lines.stream()
//                .map(n -> String.valueOf(n))
//                .collect(Collectors.joining());
//        logger.info("Read from file: " + listToStr);
//
//        String[] strDoubles = listToStr.split(REGEX_DELIMITER);
//        double[] result = Arrays.stream(strDoubles)
//                                .mapToDouble(Double::parseDouble)
//                                .toArray();
//        logger.info("Result of parsing line: " + Arrays.toString(result));
//        return result;
    }
}
