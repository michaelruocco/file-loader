package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClasspathFileContentLoader extends DefaultFileContentLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathFileContentLoader.class);

    public ClasspathFileContentLoader() {
        super(new ClasspathInputStreamLoader());
    }

    @Override
    public String loadContent(String path) {
        LOGGER.info("loading file content from classpath using path " + path);
        return super.loadContent(path);
    }

}
