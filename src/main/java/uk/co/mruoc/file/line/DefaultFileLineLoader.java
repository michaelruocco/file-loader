package uk.co.mruoc.file.line;

import lombok.RequiredArgsConstructor;
import uk.co.mruoc.file.BufferedReaderLoader;
import uk.co.mruoc.file.FileLoadException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class DefaultFileLineLoader implements FileLineLoader {

    private final BufferedReaderLoader bufferedReaderLoader;

    @Override
    public Collection<String> loadLines(String path) {
        try (BufferedReader reader = bufferedReaderLoader.load(path)) {
            return reader.lines().collect(Collectors.toList());
        } catch (IOException | UncheckedIOException e) {
            throw new FileLoadException(path, e);
        }
    }

}
