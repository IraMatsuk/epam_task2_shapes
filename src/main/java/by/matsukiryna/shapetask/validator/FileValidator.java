package by.matsukiryna.shapetask.validator;

import by.matsukiryna.shapetask.exception.ShapeException;

import java.io.File;

public class FileValidator {
    public static boolean isFileValidate(String fileAddress) throws ShapeException {
        if (fileAddress == null || fileAddress.isBlank()) {
            throw new ShapeException("Invalid file address" + fileAddress);
        }
        File file = new File(fileAddress);
        if (file.exists() && file.canRead() && file.isFile() && file.length() > 0) {
            return true;
        }
        return false;
    }
}
