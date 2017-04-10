package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasspathPropertyLoader implements PropertyLoader {

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public Properties load(String path) {
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            return converter.toProperties(stream);
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
