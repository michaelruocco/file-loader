package uk.co.mruoc.file.line;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import uk.co.mruoc.file.BufferedReaderLoader;
import uk.co.mruoc.file.FileLoadException;

@RequiredArgsConstructor
public class DefaultFileLineLoader implements FileLineLoader {

    private final BufferedReaderLoader bufferedReaderLoader;

    @Override
    public Collection<String> loadLines(String path) {
        try (BufferedReader reader = bufferedReaderLoader.load(path)) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileLoadException(path, e);
        }
    }
}
