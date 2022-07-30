package uk.co.mruoc.file;

import java.io.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileSystemInputStreamLoader implements InputStreamLoader {

    @Override
    public InputStream load(String path) {
        try {
            log.debug("loading input stream from file system using path {}", path);
            return new FileInputStream(path);
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(path, e);
        }
    }
}
