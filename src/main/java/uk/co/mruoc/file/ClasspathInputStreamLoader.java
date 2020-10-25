package uk.co.mruoc.file;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;

@Slf4j
public class ClasspathInputStreamLoader implements InputStreamLoader {

    @Override
    public InputStream load(String path) {
        log.debug("loading input stream from classpath using path {}", path);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new UncheckedIOException(new IOException("file not found on classpath at " + path));
        }
        return stream;
    }

}
