package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ClasspathPropertyLoader implements PropertyLoader {

    private InputStreamConverter inputStreamConverter = new InputStreamConverter();

    @Override
    public Properties load(String path) {
        try {
            try (InputStream stream = getClass().getResourceAsStream(path)) {
                return inputStreamConverter.toInputStream(stream);
            }
        } catch (IOException | NullPointerException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
