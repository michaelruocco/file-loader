package uk.co.mruoc.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class ClasspathInputStreamLoader implements InputStreamLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathInputStreamLoader.class);

    @Override
    public InputStream load(String path) {
        LOGGER.debug("loading input stream from classpath using path {}", path);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new UncheckedIOException(new IOException("file not found on classpath at " + path));
        }
        return stream;
    }

}
