package uk.co.mruoc.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

public class DefaultFileContentLoader implements FileContentLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final StreamLoader streamLoader;

    public DefaultFileContentLoader(StreamLoader streamLoader) {
        this.streamLoader = streamLoader;
    }

    @Override
    public String loadContent(String path) {
        try (InputStream stream = toStream(path)) {
            return converter.toString(stream);
        } catch (IOException | UncheckedIOException e) {
            throw new FileContentLoadException(path, e);
        }
    }

    private InputStream toStream(String path) {
        return streamLoader.load(path);
    }

}
