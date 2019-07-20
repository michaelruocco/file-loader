package uk.co.mruoc.file.line;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.mruoc.file.ClasspathBufferedReaderLoader;

import java.util.Collection;

public class ClasspathFileLineLoader extends DefaultFileLineLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathFileLineLoader.class);

    public ClasspathFileLineLoader() {
        super(new ClasspathBufferedReaderLoader());
    }

    @Override
    public Collection<String> loadLines(String path) {
        LOGGER.info("loading file lines from classpath using path " + path);
        return super.loadLines(path);
    }

}
