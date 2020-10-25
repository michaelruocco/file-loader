package uk.co.mruoc.file;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

@Slf4j
public class FileSystemInputStreamLoader implements InputStreamLoader {

    @Override
    public InputStream load(String path) {
        try {
            log.debug("loading input stream from file system using path {}", path);
            return new FileInputStream(new File(path));
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(path, e);
        }
    }

}
