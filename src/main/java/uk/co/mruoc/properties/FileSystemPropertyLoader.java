package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileSystemPropertyLoader implements PropertyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileSystemPropertyLoader.class);

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public Properties load(String path) {
        LOGGER.info("loading properties from file system path " + path);
        try (InputStream stream = new FileInputStream(new File(path))) {
            return converter.toProperties(stream);
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
