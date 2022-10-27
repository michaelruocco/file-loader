package uk.co.mruoc.file;

import java.io.InputStream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class ClasspathInputStreamLoader implements InputStreamLoader {

    private final PathValidator pathValidator;

    public ClasspathInputStreamLoader() {
        this(new PathValidator());
    }

    @Override
    public InputStream load(String path) {
        pathValidator.validate(path);
        log.debug("loading input stream from classpath using path {}", path);
        InputStream stream = getClass().getClassLoader().getResourceAsStream(path);
        if (stream == null) {
            throw new FileLoadException(String.format("file not found on classpath at %s", path));
        }
        return stream;
    }
}
