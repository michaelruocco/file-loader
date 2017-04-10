package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathFileContentLoader implements FileContentLoader {

    private InputStreamConverter converter = new InputStreamConverter();

    @Override
    public String loadContent(String path) {
        try (InputStream stream = getClass().getResourceAsStream(path)) {
            return converter.toString(stream);
        } catch (IOException | NullPointerException e) {
            throw new FileContentLoadException(path, e);
        }
    }

}
