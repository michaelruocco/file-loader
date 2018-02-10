package uk.co.mruoc.properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ClasspathPropertyLoader extends DefaultPropertyLoader {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClasspathPropertyLoader.class);

    public ClasspathPropertyLoader() {
        super(new ClasspathInputStreamLoader());
    }

    @Override
    public Properties load(String path) {
        LOGGER.info("loading properties from classpath using path " + path);
        return super.load(path);
    }

}
