package uk.co.mruoc.file.line;

import uk.co.mruoc.file.InputStreamConverter;
import uk.co.mruoc.file.InputStreamLoader;
import uk.co.mruoc.file.FileLoadException;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Collection;

public class DefaultFileLineLoader implements FileLineLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final InputStreamLoader inputStreamLoader;

    public DefaultFileLineLoader(InputStreamLoader inputStreamLoader) {
        this.inputStreamLoader = inputStreamLoader;
    }

    @Override
    public Collection<String> loadLines(String path) {
        try (InputStream stream = toStream(path)) {
            return converter.toLines(stream);
        } catch (IOException | UncheckedIOException e) {
            throw new FileLoadException(path, e);
        }
    }

    private InputStream toStream(String path) {
        return inputStreamLoader.load(path);
    }

}
