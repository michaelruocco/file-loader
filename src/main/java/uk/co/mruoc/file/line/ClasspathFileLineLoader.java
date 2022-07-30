package uk.co.mruoc.file.line;

import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import uk.co.mruoc.file.ClasspathBufferedReaderLoader;

@Slf4j
public class ClasspathFileLineLoader extends DefaultFileLineLoader {

    public ClasspathFileLineLoader() {
        super(new ClasspathBufferedReaderLoader());
    }

    @Override
    public Collection<String> loadLines(String path) {
        log.debug("loading file lines from classpath using path {}", path);
        return super.loadLines(path);
    }
}
