package uk.co.mruoc.file;

import org.apache.commons.lang3.StringUtils;

public class PathValidator {

    public void validate(String path) {
        if (StringUtils.isEmpty(path)) {
            throw new FileLoadException("path should not be null or empty");
        }
    }
}
