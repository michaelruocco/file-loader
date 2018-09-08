package uk.co.mruoc.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;

public class DefaultPropertyLoader implements PropertyLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final InputStreamLoader inputStreamLoader;

    public DefaultPropertyLoader(InputStreamLoader inputStreamLoader) {
        this.inputStreamLoader = inputStreamLoader;
    }

    @Override
    public Properties load(String path) {
        try (InputStream stream = inputStreamLoader.load(path)) {
            return converter.toProperties(stream);
        } catch (IOException | UncheckedIOException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }

}
