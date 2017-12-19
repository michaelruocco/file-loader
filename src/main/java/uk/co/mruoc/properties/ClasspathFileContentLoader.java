package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathFileContentLoader implements FileContentLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathFileContentLoader.class);

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public String loadContent(String path) {
        LOGGER.info("loading file content from classpath using path " + path);
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            return converter.toString(stream);
        } catch (IOException | NullPointerException e) {
            throw new FileContentLoadException(path, e);
        }
    }

}
