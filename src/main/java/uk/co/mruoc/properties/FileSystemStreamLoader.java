package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class FileSystemStreamLoader implements StreamLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemStreamLoader.class);

    @Override
    public InputStream load(String path) {
        try {
            LOGGER.debug("loading input stream from file system using path " + path);
            return new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(path, e);
        }
    }

}
