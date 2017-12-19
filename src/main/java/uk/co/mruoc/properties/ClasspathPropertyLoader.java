package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasspathPropertyLoader implements PropertyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathPropertyLoader.class);

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public Properties load(String path) {
        LOGGER.info("loading properties from classpath using path " + path);
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            return converter.toProperties(stream);
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
