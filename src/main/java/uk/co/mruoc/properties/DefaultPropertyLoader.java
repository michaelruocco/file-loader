package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class DefaultPropertyLoader implements PropertyLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final StreamLoader streamLoader;

    public DefaultPropertyLoader(StreamLoader streamLoader) {
        this.streamLoader = streamLoader;
    }

    @Override
    public Properties load(String path) {
        try (InputStream stream = streamLoader.load(path)) {
            return converter.toProperties(stream);
        } catch (IOException | UncheckedIOException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
