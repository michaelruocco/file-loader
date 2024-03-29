package uk.co.mruoc.file.content;

import java.io.IOException;
import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import uk.co.mruoc.file.FileLoadException;
import uk.co.mruoc.file.InputStreamConverter;
import uk.co.mruoc.file.InputStreamLoader;

@RequiredArgsConstructor
public class DefaultFileContentLoader implements FileContentLoader {

    private final InputStreamConverter converter = new InputStreamConverter();
    private final InputStreamLoader inputStreamLoader;

    @Override
    public String loadContent(String path) {
        try (InputStream stream = toStream(path)) {
            return converter.toString(stream);
        } catch (IOException e) {
            throw new FileLoadException(path, e);
        }
    }

    private InputStream toStream(String path) {
        return inputStreamLoader.load(path);
    }
}
