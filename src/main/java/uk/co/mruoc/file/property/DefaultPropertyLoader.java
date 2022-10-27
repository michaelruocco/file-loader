package uk.co.mruoc.file.property;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import uk.co.mruoc.file.InputStreamConverter;
import uk.co.mruoc.file.InputStreamLoader;

@RequiredArgsConstructor
public class DefaultPropertyLoader implements PropertyFileLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final InputStreamLoader inputStreamLoader;

    @Override
    public Properties load(String path) {
        try (InputStream stream = inputStreamLoader.load(path)) {
            return converter.toProperties(stream);
        } catch (IOException | UncheckedIOException e) {
            throw new PropertiesNotFoundException(path, e);
        }
    }
}
