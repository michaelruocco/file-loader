package uk.co.mruoc.file;

import java.io.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class FileSystemInputStreamLoader implements InputStreamLoader {

    private final PathValidator pathValidator;

    public FileSystemInputStreamLoader() {
        this(new PathValidator());
    }

    @Override
    public InputStream load(String path) {
        pathValidator.validate(path);
        try {
            log.debug("loading input stream from file system using path {}", path);
            return new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new FileLoadException(path, e);
        }
    }
}
