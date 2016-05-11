package uk.co.mruoc.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

    public Properties loadFromClasspath(String path) {
        try {
            try (InputStream stream = getClass().getResourceAsStream(path)) {
                return load(stream);
            }
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

    public Properties load(String path) {
        try {
            try (InputStream stream = new FileInputStream(new File(path))) {
                return load(stream);
            }
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

    private Properties load(InputStream stream) throws IOException {
        Properties properties = new Properties();
        properties.load(stream);
        return properties;
    }

}
