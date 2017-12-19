package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemFileContentLoader implements FileContentLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemFileContentLoader.class);

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public String loadContent(String path) {
        LOGGER.info("loading file content from file system path " + path);
        try (InputStream stream = new FileInputStream(new File(path))) {
            return converter.toString(stream);
        } catch (IOException | NullPointerException e) {
            throw new FileContentLoadException(path, e);
        }
    }

}
